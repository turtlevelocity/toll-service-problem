package com.tollService.models;

public abstract class Pass {

    private Toll toll;
    private TollBooth tollBooth;
    private Vehicle vehicle;

    PassStatus status;

    public Pass(Toll toll, TollBooth tollBooth, Vehicle vehicle){
        this.toll = toll;
        this.tollBooth = tollBooth;
        this.vehicle = vehicle;
    }

    public Toll getToll() {
        return toll;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setStatus(PassStatus status) {
        this.status = status;
    }

    public TollBooth getTollBooth() {
        return tollBooth;
    }

    public abstract boolean isValidPass(Pass pass, Toll toll);

//    public abstract void updatePass();

}
