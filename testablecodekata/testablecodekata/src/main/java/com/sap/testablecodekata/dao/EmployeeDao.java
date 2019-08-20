package com.sap.testablecodekata.dao;

import com.sap.testablecodekata.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDao {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDao(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {

        return employeeRepository.findAll();
    }

    public void save(List<Employee> e) {
        employeeRepository.saveAll(e);
    }
}
