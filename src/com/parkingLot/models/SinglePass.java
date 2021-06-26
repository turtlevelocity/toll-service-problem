package com.parkingLot.models;

public class SinglePass extends Pass{

    public SinglePass(Toll toll, TollBooth booth) {
        super(toll, booth);
    }

    @Override
    public boolean isValidPass(Vehicle vehicle, Toll toll) {
        Pass pass = vehicle.getPass();
        if(pass.getToll().equals(toll)){
            if(pass.status==PassStatus.VALID){
                pass.setStatus(PassStatus.EXPIRED);
                return true;
            }
            return false;
        }
        return false;
    }

}
