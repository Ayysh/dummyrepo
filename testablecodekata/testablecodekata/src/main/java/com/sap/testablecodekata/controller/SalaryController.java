package com.sap.testablecodekata.controller;

import com.sap.testablecodekata.domain.Employee;
import com.sap.testablecodekata.service.CurrencyEnum;
import com.sap.testablecodekata.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;


// this is just controller
@RestController
public class SalaryController {

    private SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

	//this is a findHighestPaidEmployeeForAllCurrencies
    @GetMapping(path = "/employees")
    public ResponseEntity<Map<CurrencyEnum, Employee>> findHighestPaidEmployeeForAllCurrencies() {
		
		//creates a responseentity and add highest paid employees
        return ResponseEntity.status(OK).body(salaryService.findHighestPaidEmployeeForAllCurrencies());
    }
}
