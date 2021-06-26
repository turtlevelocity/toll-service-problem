package com.tollService.services;

import com.tollService.exceptions.PassNotFoundException;
import com.tollService.exceptions.VehicleNotFoundException;
import com.tollService.models.Pass;
import com.tollService.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleService {

    private Map<String, Pass> vehiclePass;
    private Map<String, Vehicle> vehicle;

    public VehicleService(){
        this.vehiclePass = new HashMap<>();
        this.vehicle = new HashMap<>();
    }

    public Pass getVehiclePass(String vehicleId) {
         if(!vehiclePass.containsKey(vehicleId)){
             throw new PassNotFoundException();
         }
         return vehiclePass.get(vehicleId);
    }

    public void addVehicle(String id, Vehicle vehicle) {
        this.vehicle.put(id, vehicle);
    }

    public void addVehiclePass(String id, Pass pass) {
        this.vehiclePass.put(id, pass);
    }


    public Vehicle getVehicle(String id){
        if(!vehicle.containsKey(id)){
            throw new VehicleNotFoundException();
        }
        return vehicle.get(id);
    }
}
