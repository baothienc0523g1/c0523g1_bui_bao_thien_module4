package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyConverter {
    public double currencyConverter(double usd) {
        double result = usd * 23000;
        return result;
    }
}
