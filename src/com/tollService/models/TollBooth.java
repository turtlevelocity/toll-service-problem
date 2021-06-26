package com.tollService.models;

public class TollBooth {
    private String id;
    private boolean active;
    private LeaderBoard leaderBoard;

    public TollBooth(String id){
        this.id = id;
        this.active = false;
        this.leaderBoard = new LeaderBoard(0, 0);
    }

    public void activateBooth(){
        this.active = true;
    }

    public void deactivateBooth(){
        this.active = false;
    }

    public void updateLeaderBoard(Integer numberOfVehicles, double amount){
        this.leaderBoard.setTotalVehicles(numberOfVehicles);
        this.leaderBoard.setTotalAmount(amount);
    }
}
