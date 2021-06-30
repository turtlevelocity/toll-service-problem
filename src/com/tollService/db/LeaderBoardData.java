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
    private Map<TollBooth, List<Pass>>boothLeaderBoardMap;
    private static LeaderBoardData leaderBoardData=null;

    private LeaderBoardData(){
        this.boothLeaderBoardMap = new HashMap<>();
    }

    public static LeaderBoardData getInstance(){
        if(leaderBoardData==null){
           leaderBoardData = new LeaderBoardData();
        }
        return leaderBoardData;
    }

    public void updateTollBoothLeaderBoard(TollBooth booth, Pass pass){
        List<Pass> passes = boothLeaderBoardMap.get(booth);
        passes.add(pass);
        boothLeaderBoardMap.put(booth, passes);

    }

    public void addBooth(TollBooth booth){
        List<Pass> passes = new ArrayList<>();
        this.boothLeaderBoardMap.put(booth, passes);
    }

    public List<Pass> getBoothPasses(TollBooth booth) {
        return boothLeaderBoardMap.get(booth);
    }
}
