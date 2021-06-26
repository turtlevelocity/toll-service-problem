package com.tollService.models;

public abstract class Pass {

    private Toll toll;
    private TollBooth tollBooth;

    PassStatus status;

    public Pass(Toll toll, TollBooth tollBooth){
        this.toll = toll;
        this.tollBooth = tollBooth;
        this.status = PassStatus.VALID;
    }

    public Toll getToll() {
        return toll;
    }

    public void setStatus(PassStatus status) {
        this.status = status;
    }

    public TollBooth getTollBooth() {
        return tollBooth;
    }

    public abstract boolean isValidPass(Vehicle vehicle, Toll toll);

}
