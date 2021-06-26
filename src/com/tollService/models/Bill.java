package com.tollService.models;

public class Bill {
    private final double amount;
    private final Vehicle vehicle;
    private final Pass pass;
    private final Toll toll;

    public Bill(double amount, Vehicle vehicle, Pass pass, Toll toll){
        this.amount = amount;
        this.pass = pass;
        this.vehicle = vehicle;
        this.toll = toll;
    }

    public double getAmount() {
        return amount;
    }
}
