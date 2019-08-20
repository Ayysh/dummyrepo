package com.sap.testablecodekata.service;

import com.sap.testablecodekata.dao.EmployeeDao;
import com.sap.testablecodekata.domain.Employee;
import com.sap.testablecodekata.domain.Salary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sap.testablecodekata.service.CurrencyEnum.EUR;
import static com.sap.testablecodekata.service.CurrencyEnum.INR;

@SpringBootTest
public class SalaryServiceImplTest {

    SalaryServiceImpl salaryServiceTest;
    EmployeeDao employeeRepositoryMock;

    @Before
    public void setup(){
     employeeRepositoryMock = Mockito.mock(EmployeeDao.class);
    salaryServiceTest = new SalaryServiceImpl(employeeRepositoryMock);
    }

    @Test
    public void findHighestPaidEmployeeForAllCurrencies() throws ParseException {

        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setAddress("Bruchsal");
        employee.setId(10);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date= formatter.parse("10/05/1992");
        employee.setDob(date);
        Salary sal = new Salary();
        sal.setAmount(2000);
        sal.setCurrency(EUR);
        employee.setSalary(sal);
        employeeList.add(employee);

        Employee employee2 = new Employee();
        employee2.setAddress("Bonn");
        employee2.setId(11);
        Date date2= formatter.parse("11/06/1992");
        employee2.setDob(date2);
        Salary sal2 = new Salary();
        sal2.setAmount(700);
        sal2.setCurrency(EUR);
        employee2.setSalary(sal2);
        employeeList.add(employee2);

        Employee employee3 = new Employee();
        employee3.setAddress("Karlsruhe");
        employee3.setId(12);
        Date date3= formatter.parse("12/07/1987");
        employee3.setDob(date3);
        Salary sal3 = new Salary();
        sal3.setAmount(2380);
        sal3.setCurrency(EUR);
        employee3.setSalary(sal3);
        employeeList.add(employee3);


        Employee employee4 = new Employee();
        employee4.setAddress("Blr");
        employee4.setId(20);
        Date date4= formatter.parse("17/09/1980");
        employee4.setDob(date4);
        Salary sal4 = new Salary();
        sal4.setAmount(40000);
        sal4.setCurrency(INR);
        employee4.setSalary(sal4);
        employeeList.add(employee4);


        Employee employee6 = new Employee();
        employee6.setAddress("Goa");
        employee6.setId(22);
        Date date6= formatter.parse("24/03/1997");
        employee6.setDob(date6);
        Salary sal6 = new Salary();
        sal6.setAmount(33800);
        sal6.setCurrency(INR);
        employee6.setSalary(sal6);
        employeeList.add(employee6);


        Employee employee5 = new Employee();
        employee5.setAddress("Delhi");
        employee5.setId(21);
        Date date5= formatter.parse("28/02/1982");
        employee5.setDob(date5);
        Salary sal5 = new Salary();
        sal5.setAmount(47000);
        sal5.setCurrency(INR);
        employee5.setSalary(sal5);
        employeeList.add(employee5);

        Mockito.when(employeeRepositoryMock.findAll()).thenReturn(employeeList);
        Map<CurrencyEnum, Employee> employeeMap = salaryServiceTest.findHighestPaidEmployeeForAllCurrencies();

        Assert.assertEquals(12, employeeMap.get(CurrencyEnum.EUR).getId());
        Assert.assertEquals("Karlsruhe",employeeMap.get(CurrencyEnum.EUR).getAddress());
        Assert.assertEquals(2380,employeeMap.get(CurrencyEnum.EUR).getSalary().getAmount().doubleValue(),0);
        Assert.assertEquals(EUR,employeeMap.get(CurrencyEnum.EUR).getSalary().getCurrency());
        Assert.assertEquals("Sun Jul 12 00:00:00 CEST 1987",employeeMap.get(CurrencyEnum.EUR).getDob().toString());

        Assert.assertEquals(21, employeeMap.get(CurrencyEnum.INR).getId());
        Assert.assertEquals("Delhi",employeeMap.get(CurrencyEnum.INR).getAddress());
        Assert.assertEquals(47000,employeeMap.get(CurrencyEnum.INR).getSalary().getAmount().doubleValue(),0);
        Assert.assertEquals(INR,employeeMap.get(CurrencyEnum.INR).getSalary().getCurrency());
        Assert.assertEquals("Sun Feb 28 00:00:00 CET 1982",employeeMap.get(CurrencyEnum.INR).getDob().toString());


    }

    @Test
    public void findHighestPaidForEachCurrency() throws ParseException {

        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee();
        employee.setAddress("Bruchsal");
        employee.setId(10);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date= formatter.parse("10/05/1992");
        employee.setDob(date);
        Salary sal = new Salary();
        sal.setAmount(2000);
        sal.setCurrency(EUR);
        employee.setSalary(sal);
        employeeList.add(employee);

        Employee employee2 = new Employee();
        employee2.setAddress("Bonn");
        employee2.setId(11);
        Date date2= formatter.parse("11/06/1992");
        employee2.setDob(date2);
        Salary sal2 = new Salary();
        sal2.setAmount(700);
        sal2.setCurrency(EUR);
        employee2.setSalary(sal2);
        employeeList.add(employee2);

        Employee employee3 = new Employee();
        employee3.setAddress("Karlsruhe");
        employee3.setId(12);
        Date date3= formatter.parse("12/07/1987");
        employee3.setDob(date3);
        Salary sal3 = new Salary();
        sal3.setAmount(2380);
        sal3.setCurrency(EUR);
        employee3.setSalary(sal3);
        employeeList.add(employee3);

        Employee emp = salaryServiceTest.findHighestPaidForEachCurrency(EUR ,employeeList);
        Assert.assertEquals(12, emp.getId());
        Assert.assertEquals("Karlsruhe",emp.getAddress());
        Assert.assertEquals(2380,emp.getSalary().getAmount().doubleValue(),0);
        Assert.assertEquals(EUR,emp.getSalary().getCurrency());
        Assert.assertEquals("Sun Jul 12 00:00:00 CEST 1987",emp.getDob().toString());
    }
}