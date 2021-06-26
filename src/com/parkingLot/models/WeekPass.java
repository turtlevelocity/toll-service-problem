package com.parkingLot.models;

public class WeekPass extends Pass {

    private Long validUpto;
    public WeekPass(Toll toll, TollBooth booth) {
        super(toll, booth);
        this.validUpto = System.currentTimeMillis();
    }

    @Override
    public boolean isValidPass(Vehicle vehicle, Toll toll) {

        if(vehicle.getPass().status==PassStatus.EXPIRED){
            return false;
        }
        if(System.currentTimeMillis() > this.validUpto){
            vehicle.getPass().setStatus(PassStatus.EXPIRED);
            return false;
        }
        return true;
    }
}
