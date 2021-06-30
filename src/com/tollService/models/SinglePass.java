package com.tollService.models;

import java.util.UUID;

public class SinglePass extends Pass{

    private String id;

    public SinglePass(Toll toll, TollBooth booth, Vehicle vehicle, Bill bill) {
        super(toll, booth, vehicle, bill);
        this.status = PassStatus.VALID;
        this.id = UUID.randomUUID().toString();
        this.type = PassType.SINGLE;
    }

    @Override
    public boolean isValidPass(Toll toll){
        return (this.status==PassStatus.VALID && this.getToll().equals(toll));
    }

    @Override
    public void updatePass(){
        this.setStatus(PassStatus.EXPIRED);
    }
}
