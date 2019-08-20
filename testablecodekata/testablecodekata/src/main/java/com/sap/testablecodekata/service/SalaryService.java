package com.sap.testablecodekata.service;

import com.sap.testablecodekata.domain.Employee;

import java.util.Map;

public interface SalaryService {

    /**
     * @return
     */
    Map<CurrencyEnum, Employee> findHighestPaidEmployeeForAllCurrencies();

}
