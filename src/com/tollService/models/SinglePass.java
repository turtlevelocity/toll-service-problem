package com.tollService.models;

import java.util.UUID;

public class SinglePass extends Pass{

    private String id;

    public SinglePass(Toll toll, TollBooth booth, Vehicle vehicle) {
        super(toll, booth, vehicle);
        this.status = PassStatus.EXPIRED;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean isValidPass(Pass pass, Toll toll){
        return (pass.status==PassStatus.VALID && pass.getToll().equals(toll));
    }

    public void updatePass(Pass pass){
        this.setStatus(PassStatus.EXPIRED);
    }
}
