package com.tollService.controllers;

import com.tollService.models.LeaderBoard;
import com.tollService.models.Pass;
import com.tollService.models.Toll;
import com.tollService.models.TollBooth;
import com.tollService.models.Vehicle;
import com.tollService.services.TollService;

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
