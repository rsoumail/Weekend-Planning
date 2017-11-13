package fr.istic.m2il.weekendplanning.service.weather;

import java.util.ArrayList;
import java.util.List;

public class FcstDay {
    private String date;
    private String date_short;
    private String tmin;
    private String tmax;
    private String condition ;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_Short() {
        return date_short;
    }

    public void setDate_Short(String date_short) {
        this.date_short = date_short;
    }

    public String gettmin() {
        return tmin;
    }

    public void settmin(String tmin) {
        this.tmin = tmin;
    }

    public String gettmax() {
        return tmax;
    }

    public void settmax(String tmax) {
        this.tmax = tmax;
    }

    public String getCondition() {
        return condition;
    }

    public void setConditions(String  condition) {
        this.condition = condition;
    }
}
