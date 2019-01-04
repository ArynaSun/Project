package com.epam.jwt.task5.util;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyHelper {
    private static final String PROPERTIES_MESSAGE = "property.message";
    private static final String ISO_8859_1 = "ISO-8859-1";
    private static final String CP_1251 = "cp1251";
    private static final String UTF_8 = "UTF-8";
    private static final String PROPERTY_SERVICE_WORDS = "property.words";

    public static String receiveMessage(String key){
        return receiveMessage(key, CP_1251);
    }

    public static String receiveMessageUTF_8(String key){
        return receiveMessage(key, UTF_8);
    }

    public static String receiveMessage(String key, String encoding){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTIES_MESSAGE, LocaleHelper.getLocale());
        String value = resourceBundle.getString(key);

        try {
            return new String(value.getBytes(ISO_8859_1), encoding);
        } catch (UnsupportedEncodingException e) {
            return value;
        }
    }

    public static String receiveServiceWord(String key){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTY_SERVICE_WORDS, LocaleHelper.getLocale());
        String value = resourceBundle.getString(key);

        try {
            return new String(value.getBytes(ISO_8859_1), CP_1251);
        } catch (UnsupportedEncodingException e) {
            return value;
        }
    }
}
