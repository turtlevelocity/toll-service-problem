package com.tollService.db;

import com.tollService.exceptions.AlreadyExistException;
import com.tollService.models.Toll;
import com.tollService.models.TollBooth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollServiceData {

    private Map<Toll, List<TollBooth>> tollMap;

    public TollServiceData(){
        this.tollMap = new HashMap<>();
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
}
