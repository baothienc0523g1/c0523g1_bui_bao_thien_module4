package com.codegym.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int visitCount = 0;
    private static int dataChangeCount = 0;
    private static int rentTimesCount = 0;


    @After("execution(* com.codegym.controller.*.*(..))")
    public void websiteVisitCount(){
        visitCount++;
        System.out.println("số lần người dùng tương tác với website: " + visitCount);
    }

    @After("execution(* com.codegym.repository.*(..))")
    public void databaseChangeCount() {
        dataChangeCount++;
        System.out.println("số lần cơ sở dữ liệu có sự tương tác: " + dataChangeCount);
    }

    @After("execution(* com.codegym.service.IRentService.add(..))")
    public void rentTimesCount() {
        rentTimesCount++;
        System.out.println("số lần người dùng mượn sách: " + rentTimesCount);
    }
}
