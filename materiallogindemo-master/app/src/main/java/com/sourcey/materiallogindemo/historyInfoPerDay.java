package com.sourcey.materiallogindemo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alaa on 3/15/2019.
 */

public class historyInfoPerDay {
    String hour;
    String count;
    ArrayList<String> date;

    public historyInfoPerDay(String hour, String count, ArrayList<String> date) {
        this.hour = hour;
        this.count = count;
        this.date = date;
    }

    public historyInfoPerDay() {
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ArrayList<String > getDate() {
        return date;
    }

    public void setDate(ArrayList<String> date) {
        this.date = date;
    }
}