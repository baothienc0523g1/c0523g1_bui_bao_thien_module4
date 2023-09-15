package com.codegym.service;

public interface ICalculatorService {
    long minusResolver(long firstOperator, long secondOperator);
    long multiResolver(long firstOperator, long secondOperator);
    long divideResolver(long firstOperator, long secondOperator);
    long plusResolver(long firstOperator, long secondOperator);
}
