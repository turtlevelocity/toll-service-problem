package com.parkingLot.models;

public class ReturnPass extends Pass {

    private Integer numberOfTrips;

    public ReturnPass(Toll toll, TollBooth booth) {
        super(toll, booth);
        this.numberOfTrips = 0;
    }

    @Override
    public boolean isValidPass(Vehicle vehicle, Toll toll) {
        Pass pass = vehicle.getPass();
        if(pass.getToll().equals(toll)){
            if(pass.status==PassStatus.EXPIRED){
                return false;
            }
            this.numberOfTrips = this.numberOfTrips+1;
            if(this.numberOfTrips==2){
                pass.setStatus(PassStatus.EXPIRED);
            }
            return true;
        }
        return false;
    }
}
