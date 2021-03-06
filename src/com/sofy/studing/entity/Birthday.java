package com.sofy.studing.entity;

import java.util.Objects;

public class Birthday {
    private int dayBirthday;
    private int monthBirthday;
    private int yearBirthday;

    public Birthday(int dayBirthday, int monthBirthday, int yearBirthday) {
        this.dayBirthday = dayBirthday;
        this.monthBirthday = monthBirthday;
        this.yearBirthday = yearBirthday;
    }

    public int getDayBirthday() {
        return dayBirthday;
    }

    public void setDayBirthday(int dayBirthday) {
        this.dayBirthday = dayBirthday;
    }

    public int getMonthBirthday() {
        return monthBirthday;
    }

    public void setMonthBirthday(int monthBirthday) {
        this.monthBirthday = monthBirthday;
    }

    public int getYearBirthday() {
        return yearBirthday;
    }

    public void setYearBirthday(int yearBirthday) {
        this.yearBirthday = yearBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return dayBirthday == birthday.dayBirthday &&
                monthBirthday == birthday.monthBirthday &&
                yearBirthday == birthday.yearBirthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayBirthday, monthBirthday, yearBirthday);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Birthday{");
        sb.append("dayBirthday=").append(dayBirthday);
        sb.append(", monthBirthday=").append(monthBirthday);
        sb.append(", yearBirthday=").append(yearBirthday);
        sb.append('}');
        return sb.toString();
    }
}
