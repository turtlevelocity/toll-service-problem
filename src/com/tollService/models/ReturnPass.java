package com.tollService.models;

public class ReturnPass extends Pass {

    private Integer numberOfTrips;

    public ReturnPass(Toll toll, TollBooth booth, Vehicle vehicle, Bill bill) {
        super(toll, booth, vehicle, bill);
        this.status = PassStatus.VALID;
        this.numberOfTrips = 1;
    }

    @Override
    public boolean isValidPass(Toll toll){
        return (this.getToll().equals(toll) && this.status==PassStatus.VALID);
    }

    public void updatePass(Pass pass){
        this.numberOfTrips++;
        this.setStatus(PassStatus.EXPIRED);
    }
}
