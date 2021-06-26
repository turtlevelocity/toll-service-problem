package com.parkingLot.models;

import java.util.ArrayList;
import java.util.List;

public class Toll {

    private String id;
    private List<TollBooth> booths;

    public Toll(String id){
        this.id = id;
        this.booths = new ArrayList<>();
    }


    public void addBooth(TollBooth booth){
        this.booths.add(booth);
    }
}
