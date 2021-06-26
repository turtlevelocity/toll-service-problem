package com.parkingLot.models;

import java.util.ArrayList;
import java.util.List;

public class TollCompany {

    private String id;
    private String name;
    private List<Toll> tolls;

    public TollCompany(String id, String name){
        this.id = id;
        this.name = name;
        this.tolls = new ArrayList<>();
    }

    public void addToll(Toll newToll){
        tolls.add(newToll);
    }
}
