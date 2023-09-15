package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("")
    public String getTimeByTimezone(ModelMap modelMap, @RequestParam(name = "city", required = false, defaultValue = "Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);

        Long localeTime = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime((localeTime) );
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("date", date);
        return "index";
    }
}
