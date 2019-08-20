package com.sap.testablecodekata.domain;

import com.sap.testablecodekata.service.CurrencyEnum;

import javax.persistence.*;


@Entity(name = "Salary")
@Table(name = "service")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salaryId")
    private int salaryId;

    @Column(name = "currency")
    private CurrencyEnum currency;

    @Column(name = "amount")
    private Double amount;

    @OneToOne(mappedBy = "service")
    private Employee employee;


    public Salary() {
    }

    public Salary(CurrencyEnum currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {

        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
}
