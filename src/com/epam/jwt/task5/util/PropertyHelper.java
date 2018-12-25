package com.epam.jwt.task5.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyHelper {
    private static final String PROPERTIES_MESSAGE = "message";

    public static String receiveMessage(String key){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_MESSAGE, LocaleHelper.getLocale());
        String value = resourceBundle.getString(key);

        return value;
    }
}
