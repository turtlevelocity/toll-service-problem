package com.tollService.models;

public class ReturnPass extends Pass {

    private Integer numberOfTrips;

    public ReturnPass(Toll toll, TollBooth booth, Vehicle vehicle) {
        super(toll, booth, vehicle);
        this.status = PassStatus.VALID;
        this.numberOfTrips = 1;
    }

    @Override
    public boolean isValidPass(Pass pass, Toll toll){
        return (pass.getToll().equals(toll) && pass.status==PassStatus.VALID);
    }

    public void updatePass(Pass pass){
        this.numberOfTrips++;
        this.setStatus(PassStatus.EXPIRED);
    }
}
