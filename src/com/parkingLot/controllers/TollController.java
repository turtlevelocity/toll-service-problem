package com.parkingLot.controllers;

import com.parkingLot.models.LeaderBoard;
import com.parkingLot.models.Pass;
import com.parkingLot.models.Toll;
import com.parkingLot.models.TollBooth;
import com.parkingLot.models.Vehicle;
import com.parkingLot.services.TollService;

public class TollController {
    private final TollService tollService;

    public TollController(TollService tollService){
        this.tollService = tollService;
    }

    public boolean validatePass(String vehicleId, TollBooth booth, Toll toll){
        return tollService.isValidPass(toll, booth, vehicleId);
    }

    public void addPass(Pass pass, String vehicleId, Vehicle vehicle){
        tollService.addPass(pass, vehicleId, vehicle);
    }

    public LeaderBoard getTollLeaderBoard(Toll toll, TollBooth tollBooth){
        return tollService.getLeaderBoard(toll, tollBooth);
    }
}
