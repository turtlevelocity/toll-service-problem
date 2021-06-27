package com.tollService.db;

import com.tollService.exceptions.AlreadyExistException;
import com.tollService.models.Toll;
import com.tollService.models.TollBooth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollServiceData {

    private static TollServiceData tollServiceData = null;
    private Map<Toll, List<TollBooth>> tollMap;

    private TollServiceData(){
        this.tollMap = new HashMap<>();
    }

    public static TollServiceData getInstance(){
        if(tollServiceData==null){
            tollServiceData = new TollServiceData();
        }
        return tollServiceData;
    }

    public List<TollBooth> getTollBooths(Toll toll) {
        return tollMap.get(toll);
    }

    public void updateTollData(Toll toll, TollBooth booth){
        if(!tollMap.containsKey(toll)){
            List<TollBooth> booths = new ArrayList<>();
            tollMap.put(toll, booths);
        }
        List<TollBooth> booths = this.tollMap.get(toll);
        if(booths.contains(booth)){
            throw new AlreadyExistException();
        }
        booths.add(booth);
        this.tollMap.put(toll, booths);
    }

    public boolean validateBooth(Toll toll, TollBooth booth){
        if(!validateToll(toll)){
            return false;
        }
        List<TollBooth> booths = this.tollMap.get(toll);
        if(!booths.contains(booth)){
            return false;
        }
        return true;
    }

    public boolean validateToll(Toll toll){
        return tollMap.containsKey(toll);
    }
}
