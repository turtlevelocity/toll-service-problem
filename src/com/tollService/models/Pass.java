package com.tollService.models;

public abstract class Pass {

    private Toll toll;
    private TollBooth tollBooth;
    private Vehicle vehicle;
    private Bill bill;
    protected PassType type;
    protected PassStatus status;

    public Pass(Toll toll, TollBooth tollBooth, Vehicle vehicle, Bill bill){
        this.toll = toll;
        this.tollBooth = tollBooth;
        this.vehicle = vehicle;
        this.bill = bill;
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

    public abstract boolean isValidPass(Toll toll);

    public abstract void updatePass();

    public Bill getBill(){
        return bill;
    }

    public PassType getType(){
        return this.type;
    }
}
