package com.tollService.models;

public abstract class Vehicle {
    private String number;
    private Pass pass;

    public Vehicle(String number, Pass pass){
        this.number = number;
        this.pass = pass;
    }

    public String getNumber(){
        return number;
    }

    public Pass getPass() {
        return pass;
    }

}
