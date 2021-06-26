package com.tollService.services;

import com.tollService.exceptions.AlreadyExistException;
import com.tollService.models.LeaderBoard;
import com.tollService.models.Pass;
import com.tollService.models.Toll;
import com.tollService.models.TollBooth;
import com.tollService.models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TollService {
    private Map<Toll, Map<TollBooth, List<Vehicle>>> tolls;
    private VehicleService vehicleService;

    public TollService(VehicleService vehicleService){
        this.tolls = new HashMap<>();
        this.vehicleService = vehicleService;
    }

    private void updateTolls(Toll toll, TollBooth booth, Vehicle vehicle){
        Map<TollBooth, List<Vehicle>> boothListMap = tolls.get(toll);
        boothListMap.get(booth).add(vehicle);
    }

    public void addTollBooth(Toll toll, TollBooth booth){
        toll.addBooth(booth);
        if(!this.tolls.containsKey(toll)){
            this.tolls.put(toll, new HashMap<>());
        }
        if(this.tolls.get(toll).containsKey(booth)){
            throw new AlreadyExistException();
        }
        this.tolls.get(toll).put(booth, new ArrayList<>());
    }

    public boolean isValidPass(Toll toll, TollBooth booth, String vehicleId){
        Pass pass = vehicleService.getVehiclePass(vehicleId);
        if(!pass.getToll().equals(toll)){
            return false;
        }
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);

       return pass.isValidPass(vehicle, toll);

    }

    public void addPass(Pass pass, String vehicleId, Vehicle vehicle){
        vehicleService.addVehicle(vehicleId, vehicle);
        vehicleService.addVehiclePass(vehicleId, pass);
        Toll toll = pass.getToll();
        TollBooth booth = pass.getTollBooth();
        this.updateTolls(toll, booth, vehicle);
    }

    public LeaderBoard getLeaderBoard(Toll toll, TollBooth tollBooth){
        List<Vehicle> vehicles = tolls.get(toll).get(tollBooth);
        double totalAmount = 0;
        for(Vehicle vehicle: vehicles){
            totalAmount+=vehicle.getPrice();
        }
        return new LeaderBoard(vehicles.size(), totalAmount);
    }
}
