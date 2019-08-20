package com.sap.testablecodekata.service;


import com.sap.testablecodekata.dao.EmployeeDao;
import com.sap.testablecodekata.domain.Employee;
import com.sap.testablecodekata.exception.NoEmployeeFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    public SalaryServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Map<CurrencyEnum, Employee> findHighestPaidEmployeeForAllCurrencies() {
        //Create a Employee Map having currencyenum as key and domain as value
        Map<CurrencyEnum, Employee> employeeMap = new HashMap<>();
        // for every currencyvalue in the enum
        for (CurrencyEnum c : CurrencyEnum.values()) {
            // get all employees from the db and store in employeelist
            List<Employee> employeeList = employeeDao.findAll();
            //iterate through the list
           Employee emp = findHighestPaidForEachCurrency(c,employeeList);
            if (emp != null) {
                employeeMap.put(c, emp);
            }
            else
            {
                throw new NoEmployeeFoundException(" No Employee Found");
            }
        }
        return employeeMap;
    }

    /**
     * This method finds the highest paid domain for every currency
     * @param currencyEnum
     * @return Employee
     */
    public Employee findHighestPaidForEachCurrency(CurrencyEnum currencyEnum, List<Employee> employeeList)
    {
        Employee emp = new Employee();
        for (Employee e:employeeList) {
            // if the currencyvalue in the enum is equal to the currency of employees
            if (e.getSalary().getCurrency() == currencyEnum){
                // assign domain to e
                emp = e;
                // if domain amount is less than amount in employeelist
                if (e.getSalary().getAmount().compareTo(e.getSalary().getAmount()) < 0) {
                    // assign domain to e
                    emp = e;
                }
            }
        }
        return emp;
    }
}
