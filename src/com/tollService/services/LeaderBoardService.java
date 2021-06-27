package com.tollService.services;

import com.tollService.db.LeaderBoardData;
import com.tollService.db.TollServiceData;
import com.tollService.exceptions.InvalidException;
import com.tollService.models.*;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardService {
    private final LeaderBoardData leaderBoardData;
    private final TollServiceData tollServiceData;

    public LeaderBoardService(){
        this.leaderBoardData = LeaderBoardData.getInstance();
        this.tollServiceData = TollServiceData.getInstance();
    }

    public LeaderBoard getLeaderBoard(Toll toll){
        if(!tollServiceData.validateToll(toll)){
            throw new InvalidException();
        }

        List<TollBooth> booths = tollServiceData.getTollBooths(toll);
        List<Pass> totalPasses = new ArrayList<>();

        for(TollBooth booth: booths){
            totalPasses.addAll(leaderBoardData.getBoothPasses(booth));
        }

        return new LeaderBoard(totalPasses.size(), getTotalAmount(totalPasses));
    }

    public LeaderBoard getTollBoothLeaderBoard(Toll toll, TollBooth booth){
        if(!tollServiceData.validateBooth(toll, booth)){
            throw new InvalidException();
        }
        List<Pass> passes = leaderBoardData.getBoothPasses(booth);

        return new LeaderBoard(passes.size(), getTotalAmount(passes));
    }

    private double getTotalAmount(List<Pass> passes){
        double totalAmount = 0;
        for(Pass pass: passes){
            totalAmount+=pass.getBill().getAmount();
        }
        return totalAmount;
    }

    public void updateTollBoothLeaderBoard(TollBooth booth, Pass pass){
        leaderBoardData.updateTollBoothLeaderBoard(booth, pass);
    }
}
