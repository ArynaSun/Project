package com.epam.jwt.task5.util;

import java.util.Locale;

public class LocaleHelper {
    private static final ThreadLocal<Locale> threadLocal = new  ThreadLocal<>();

    public final static Locale getLocale() {
        return threadLocal.get();
    }

    public final static void setLocale(Locale locale) {
        threadLocal.set(locale);
    }
}
