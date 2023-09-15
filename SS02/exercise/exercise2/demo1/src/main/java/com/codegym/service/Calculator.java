package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator implements ICalculator {
    @Override
    public long minusResolver(long firstOperator, long secondOperator) {
        return firstOperator - secondOperator;
    }

    @Override
    public long multiResolver(long firstOperator, long secondOperator) {
        return firstOperator * secondOperator;
    }

    @Override
    public long divideResolver(long firstOperator, long secondOperator) {
        return firstOperator / secondOperator;
    }

    @Override
    public long plusResolver(long firstOperator, long secondOperator) {
        return firstOperator + secondOperator;
    }
}
