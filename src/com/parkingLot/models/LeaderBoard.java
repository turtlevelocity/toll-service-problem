package com.parkingLot.models;

public class LeaderBoard {
    private Integer numberOfVehicles;
    private double totalAmount;

    public LeaderBoard(Integer numberOfVehicles, double totalAmount){
        this.numberOfVehicles = numberOfVehicles;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Integer getNumberOfVehicles() {
        return numberOfVehicles;
    }
}
