package com.epam.jwt.task5.util;

import java.util.Locale;

public enum  Language {
    ENGLISH(new Locale("en","US")),
    RUSSIAN(new Locale("ru", "RU"));

    private final Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
