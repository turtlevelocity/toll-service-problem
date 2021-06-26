package com.tollService.models;

public abstract class Vehicle {
    private String number;
    private Pass pass;
    private double price;

    public Vehicle(String number, double price, Pass pass){
        this.number = number;
        this.price = price;
        this.pass = pass;
    }

    public Pass getPass() {
        return pass;
    }

    public double getPrice() {
        return price;
    }
}
