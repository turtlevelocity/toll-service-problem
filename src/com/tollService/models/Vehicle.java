package com.tollService.models;

public abstract class Vehicle {
    private String number;
    private Pass pass;

    public Vehicle(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public Pass getPass() {
        return pass;
    }

}
