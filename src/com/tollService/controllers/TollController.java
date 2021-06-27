package com.tollService.controllers;

import com.tollService.models.*;
import com.tollService.services.LeaderBoardService;
import com.tollService.services.TollService;

public class TollController {
    private final TollService tollService;
    private final LeaderBoardService leaderBoardService;

    public TollController(TollService tollService, LeaderBoardService leaderBoardService){
        this.tollService = tollService;
        this.leaderBoardService = leaderBoardService;
    }

    public boolean validatePass(String vehicleId, Pass pass, Toll toll){
        return tollService.isValidPass(vehicleId, pass, toll);
    }

    public Pass createPass(Vehicle vehicle, PassType passType, Toll toll, TollBooth booth){
        return tollService.createPass(vehicle, passType, toll, booth);
    }

    public void assignBoothToToll(Toll toll, TollBooth booth){
        tollService.assignBoothToToll(toll, booth);
    }

    public void updateLeaderBoard(Toll toll, TollBooth booth, Pass pass){
        leaderBoardService.updateLeaderBoard(toll, booth, pass);
    }

    public LeaderBoard getTollLeaderBoard(Toll toll){
        return leaderBoardService.getLeaderBoard(toll);
    }

    public LeaderBoard getTollBoothLeaderBoard(Toll toll, TollBooth booth){
        return leaderBoardService.getTollBoothLeaderBoard(toll, booth);
    }
}
