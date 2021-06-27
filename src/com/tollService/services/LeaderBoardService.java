package com.tollService.services;

import com.tollService.models.*;

import java.util.List;

public class LeaderBoardService {


    public void updateLeaderBoard(Toll toll, TollBooth booth, Pass pass){

    }

    public LeaderBoard getLeaderBoard(Toll toll, TollBooth tollBooth){
        List<Vehicle> vehicles = tolls.get(toll).get(tollBooth);
        double totalAmount = 0;
        for(Vehicle vehicle: vehicles){
            totalAmount+=vehicle.getPrice();
        }
        return new LeaderBoard(vehicles.size(), totalAmount);
    }

    public LeaderBoard getTollBoothLeaderBoard(Toll toll, TollBooth booth){

    }
}
