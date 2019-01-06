package com.epam.jwt.task5.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static String dateTime() {
        return dateFormat.format(new Date());
    }
}