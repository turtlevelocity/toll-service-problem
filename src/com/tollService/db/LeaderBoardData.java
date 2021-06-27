package com.tollService.db;

import com.tollService.exceptions.AlreadyExistException;
import com.tollService.models.Pass;
import com.tollService.models.Toll;
import com.tollService.models.TollBooth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderBoardData {
    private Map<Toll, List<Pass>> tollLeaderBoardMap;
    private Map<TollBooth, List<Pass>>boothLeaderBoardMap;

    public LeaderBoardData(){
        this.tollLeaderBoardMap = new HashMap<>();
        this.boothLeaderBoardMap = new HashMap<>();
    }

    public void updateTollLeaderBoard(Toll toll, Pass pass){

    }
    
    public void updateBoothLeaderBoard(TollBooth booth, Pass pass){

    }
}
