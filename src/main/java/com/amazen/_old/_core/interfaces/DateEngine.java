package com.amazen._old._core.interfaces;

public abstract class DateEngine {
    public DateEngine() {
    }

    protected DateEngine(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    protected int year;
    protected int month;
    protected int dayOfMonth;

    public abstract DateEngine now();

    public abstract boolean isAfterNow();
}
