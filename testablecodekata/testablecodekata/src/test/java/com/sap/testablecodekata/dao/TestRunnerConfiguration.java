package com.sap.testablecodekata.dao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.sap.testablecodekata")
@EnableAutoConfiguration
public class TestRunnerConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(TestRunnerConfiguration.class, args);
    }
}