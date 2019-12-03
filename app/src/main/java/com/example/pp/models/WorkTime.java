package com.example.pp.models;

import java.util.Objects;

public class WorkTime {
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private int idShop;

    public WorkTime() {
    }

    public WorkTime(int startHour, int startMinute, int endHour, int endMinute) {
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkTime workTime = (WorkTime) o;
        return startHour == workTime.startHour &&
                startMinute == workTime.startMinute &&
                endHour == workTime.endHour &&
                endMinute == workTime.endMinute &&
                idShop == workTime.idShop;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startHour, startMinute, endHour, endMinute, idShop);
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "startHour=" + startHour +
                ", startMinute=" + startMinute +
                ", endHour=" + endHour +
                ", endMinute=" + endMinute +
                ", idShop=" + idShop +
                '}';
    }
}
