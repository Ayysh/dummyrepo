package com.sap.testablecodekata.dao;

import com.sap.testablecodekata.domain.Employee;
import com.sap.testablecodekata.domain.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sap.testablecodekata.service.CurrencyEnum.*;


@ActiveProfiles("h2integration")
@ContextConfiguration(classes = TestRunnerConfiguration.class)
@SpringBootTest
public class DaoTest extends IntegrationTestBase {

    @Autowired
    private EmployeeDao employeeDao;

    Employee e1;
    Employee e2;
    Employee e3;
    Employee e4;
    Employee e5;
    Employee e6;
    Employee e7;
    Employee e8;

    @BeforeMethod
    public void setupMethod() {
        List<Employee> employeeList = new ArrayList<>();
        e1 = new Employee(10,new Date("Sun Feb 28 00:00:00 CET 1982"),"Bruchsal",new Salary(EUR,1800.0));
        e2 = new Employee(11,new Date("Sun Jul 12 00:00:00 CEST 1987"),"Bonn",new Salary(EUR,2100.0));
        e3 = new Employee(12,new Date("Wed Mar 25 00:00:00 CET 1992"),"karlsruhe",new Salary(EUR,1500.0));
        e4 = new Employee(20,new Date("Fri Oct 18 00:00:00 CET 2002"),"Bangalore",new Salary(INR,38000.0));
        e5 = new Employee(21,new Date("Sun Sep 07 00:00:00 CET 2008"),"Delhi",new Salary(INR,45000.0));
        e6 = new Employee(22,new Date("Tue May 15 00:00:00 CET 1990"),"Goa",new Salary(INR,30000.0));
        e7 = new Employee(30,new Date("Sun Jan 19 00:00:00 CET 1997"),"NY",new Salary(USD,14000.0));
        e8 = new Employee(31,new Date("Wed Nov 10 00:00:00 CET 1999"),"LA",new Salary(USD,19000.0));
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);
        employeeList.add(e8);
        employeeDao.save(employeeList);
    }

    @Test
    public void testGetAllEmployeesFromDb() {
        List<Employee> employeeList = employeeDao.findAll();

        Assert.assertEquals(e1.getId(),employeeList.get(0).getId());
    }
}