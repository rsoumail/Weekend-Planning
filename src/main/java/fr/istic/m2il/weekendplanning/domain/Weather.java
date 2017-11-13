package fr.istic.m2il.weekendplanning.domain;

import fr.istic.m2il.weekendplanning.service.weather.FcstDay;

public class Weather {

private FcstDay fcst_day_0;
private FcstDay fcst_day_1;
private FcstDay fcst_day_2;
private FcstDay fcst_day_3;

    public FcstDay getFcst_day_0() {
        return fcst_day_0;
    }

    public void setFcst_day_0(FcstDay fcst_day_0) {
        this.fcst_day_0 = fcst_day_0;
    }

    public FcstDay getFcst_day_1() {
        return fcst_day_1;
    }

    public void setFcst_day_1(FcstDay fcst_day_1) {
        this.fcst_day_1 = fcst_day_1;
    }

    public FcstDay getFcst_day_2() {
        return fcst_day_2;
    }

    public void setFcst_day_2(FcstDay fcst_day_2) {
        this.fcst_day_2 = fcst_day_2;
    }

    public FcstDay getFcst_day_3() {
        return fcst_day_3;
    }

    public void setFcst_day_3(FcstDay fcst_day_3) {
        this.fcst_day_3 = fcst_day_3;
    }
}
