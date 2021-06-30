package com.tollService.services;

import com.tollService.db.LeaderBoardData;
import com.tollService.db.TollServiceData;
import com.tollService.exceptions.AlreadyExistException;
import com.tollService.exceptions.InvalidException;
import com.tollService.exceptions.PassNotFoundException;
import com.tollService.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollService {
    private final TollServiceData tollServiceData;
    private final LeaderBoardData leaderBoardData;

    public TollService(){
        this.tollServiceData = TollServiceData.getInstance();
        this.leaderBoardData = LeaderBoardData.getInstance();
    }

    public void scanPass(Pass pass, String vehicleId, Toll toll){
        if(!isValidPass(vehicleId, pass, toll)){
            System.out.println("Not a Valid Pass");
        }
        pass.updatePass();
    }

    public Pass createPass(Vehicle vehicle, PassType passType, Toll toll, TollBooth booth){
        if(passType.equals(PassType.SINGLE)){
            return createSinglePass(vehicle, toll, booth);
        }
        if(passType.equals(PassType.RETURN)){
            return createReturnPass(vehicle, toll, booth);
        }
        if(passType.equals(PassType.WEEKLY)){
            return createWeeklyPass(vehicle, toll, booth);
        }
        throw new PassNotFoundException();
    }

    private Pass createSinglePass(Vehicle vehicle, Toll toll, TollBooth booth){
        Bill bill = new Bill(1.0, vehicle, toll);
        Pass pass = new SinglePass(toll, booth, vehicle, bill);
        return pass;
    }

    private Pass createReturnPass(Vehicle vehicle, Toll toll, TollBooth booth){
        Bill bill = new Bill(2.0, vehicle, toll);
        Pass pass = new ReturnPass(toll, booth, vehicle, bill);
        return pass;
    }

    private Pass createWeeklyPass(Vehicle vehicle, Toll toll, TollBooth booth){
        Bill bill = new Bill(3.0, vehicle, toll);
        Pass pass = new WeekPass(toll, booth, vehicle, bill);
        return pass;
    }

    public void assignBoothToToll(Toll toll, TollBooth booth){
        booth.activateBooth();
        toll.addBooth(booth);
        tollServiceData.updateTollData(toll, booth);
        leaderBoardData.addBooth(booth);
    }

    private boolean isValidPass(String vehicleId, Pass pass, Toll toll){
        return (pass.isValidPass(toll) && (pass.getVehicle().getNumber().equals(vehicleId)));
    }
}
