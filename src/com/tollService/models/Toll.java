package com.tollService.models;

import java.util.ArrayList;
import java.util.List;

public class Toll {

    private String id;
    private List<TollBooth> booths;
    private LeaderBoard leaderBoard;

    public Toll(String id){
        this.id = id;
        this.booths = new ArrayList<>();
        this.leaderBoard = new LeaderBoard(0, 0);
    }


    public void addBooth(TollBooth booth){
        this.booths.add(booth);
    }

    public void updateLeaderBoard(Integer numberOfVehicles, double amount){
        this.leaderBoard.setTotalVehicles(numberOfVehicles);
        this.leaderBoard.setTotalAmount(amount);
    }

    public void removeBooth(TollBooth booth) {
        this.booths.remove(booth);
    }
}
