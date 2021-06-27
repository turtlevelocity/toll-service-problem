package com.tollService.models;

import java.util.UUID;

public class SinglePass extends Pass{

    private String id;

    public SinglePass(Toll toll, TollBooth booth, Vehicle vehicle, Bill bill) {
        super(toll, booth, vehicle, bill);
        this.status = PassStatus.EXPIRED;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean isValidPass(Toll toll){
        return (this.status==PassStatus.VALID && this.getToll().equals(toll));
    }

    public void updatePass(Pass pass){
        this.setStatus(PassStatus.EXPIRED);
    }
}
