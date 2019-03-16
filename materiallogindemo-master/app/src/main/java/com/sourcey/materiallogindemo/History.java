package com.sourcey.materiallogindemo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alaa on 3/15/2019.
 */

public class History {

   String day ;
   ArrayList<historyInfoPerDay> info;

    public History(String day, ArrayList<historyInfoPerDay> info) {
        this.day = day;
        this.info = info;
    }

    public History() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ArrayList<historyInfoPerDay> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<historyInfoPerDay> info) {
        this.info = info;
    }
}
