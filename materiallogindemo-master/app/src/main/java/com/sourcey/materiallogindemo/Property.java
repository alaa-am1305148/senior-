package com.sourcey.materiallogindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public  class Property implements Serializable {

    //property basics

    private String zoneName;
    private String description;
    private String image;
    private int totalSpotsNo; // the total number of available spot in this zone
    private ArrayList<History> history;

    //constructor


    public Property(String zoneName, String description, String image, int totalSpotsNo) {
        this.zoneName = zoneName;
        this.description = description;
        this.image = image;
        this.totalSpotsNo = totalSpotsNo;
    }

    public Property(String zoneName, int totalSpotsNo, ArrayList<History> history) {
        this.zoneName = zoneName;
        this.totalSpotsNo = totalSpotsNo;
        this.history = history;
    }

    public Property() {

    }

    //getters




    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }


    public String getZoneName() {
        return zoneName;
    }


    public int getTotalSpotsNo() {
        return totalSpotsNo;
    }

    public ArrayList<History> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<History> history) {
        this.history = history;
    }
}