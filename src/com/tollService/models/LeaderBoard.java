package com.tollService.models;

public class LeaderBoard {
    private Integer totalVehicles;
    private double totalAmount;

    public LeaderBoard(Integer totalVehicles, double totalAmount){
        this.totalVehicles = totalVehicles;
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount+=amount;
    }

    public Integer getTotalVehicles() {
        return totalVehicles;
    }

    public void setTotalVehicles(Integer numberOfVehicles){
        this.totalVehicles+=numberOfVehicles;
    }
}
