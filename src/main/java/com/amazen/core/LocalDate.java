package com.amazen.core;

import com.amazen.core.interfaces.DateEngine;

public class LocalDate extends DateEngine {
    public LocalDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    public LocalDate() {
    }

    @Override
    public DateEngine now() {
        java.time.LocalDate date = java.time.LocalDate.now();
        return new LocalDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

    @Override
    public boolean isAfterNow() {
        return java.time.LocalDate.of(year, month, dayOfMonth).isAfter(java.time.LocalDate.now());
    }
}
