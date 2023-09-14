package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class Convert {
    public double convert(double usd) {
        double result = usd * 23000;
        return result;
    }
}
