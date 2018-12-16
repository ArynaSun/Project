package com.epam.jwt.task5.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyHelper {
    private static final String PROPERTIES_MESSAGE = "message";
    private  static Locale locale = new Locale("RU", "ru");

    public static void setLocale(Locale locale) {
        PropertyHelper.locale = locale;
    }

    public static String receiveMessage(String key){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_MESSAGE, locale);
        String value = resourceBundle.getString(key);

        return value;
    }
}
