package com.github.meleshkin.travisciplayground.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Controller
public class TimeController {

    @RequestMapping("/time")
    @ResponseBody
    String getTime() {
        Locale locale = LocaleContextHolder.getLocale();
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locale);
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
