package com.tollService;

import com.tollService.controllers.TollController;
import com.tollService.models.*;
import com.tollService.services.LeaderBoardService;
import com.tollService.services.TollService;
import com.tollService.services.VehicleService;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Initialize Service
        TollService tollService = new TollService();
        LeaderBoardService leaderBoardService = new LeaderBoardService();

        // Initialize Controller
        TollController tollController = new TollController(tollService, leaderBoardService);

        // Initialize Toll
        Toll toll1 = new Toll("1");
        Toll toll2 = new Toll("2");

        // Initialize Tollbooth
        TollBooth booth1 = new TollBooth("1");
        TollBooth booth2 = new TollBooth("2");
        TollBooth booth3 = new TollBooth("3");
        TollBooth booth4 = new TollBooth("4");

        // Add toll booth to toll
        tollController.assignBoothToToll(toll1, booth1);
        tollController.assignBoothToToll(toll1, booth2);
        tollController.assignBoothToToll(toll2, booth3);
        tollController.assignBoothToToll(toll2, booth4);

        // Initialize vehicle
        Vehicle twVehicle1 = new TwoWheelVehicle("tv1");
        Vehicle twVehicle2 = new TwoWheelVehicle("tv2");
        Vehicle fwVehicle1 = new FourWheelVehicle("fv1");
        Vehicle fwVehicle2 = new FourWheelVehicle("fv2");

        // Create Pass
        Pass pass1 = tollController.createPass(twVehicle1, PassType.SINGLE, toll1, booth1);
        Pass pass2 = tollController.createPass(twVehicle2, PassType.RETURN, toll1, booth2);
        Pass pass3 = tollController.createPass(fwVehicle1, PassType.SINGLE, toll2, booth3);
        Pass pass4 = tollController.createPass(fwVehicle2, PassType.WEEKLY, toll2, booth4);

        // Print out leader board
        System.out.println("Toll1 leaderboards: "+ tollController.getTollLeaderBoard(toll1).getTotalAmount());
        System.out.println("Booth1 leaderBoard: "+tollController.getTollBoothLeaderBoard(toll1, booth1).getTotalAmount());
        System.out.println("Booth2 leaderboard: "+tollController.getTollBoothLeaderBoard(toll1, booth2).getTotalAmount());

        // Scan Pass
        tollController.scanPass(pass1, "tv1", toll1);
        tollController.updateLeaderBoard(booth1, pass1);

        // Print out leader board
        System.out.println("Toll1 leaderboards: "+ tollController.getTollLeaderBoard(toll1).getTotalAmount());
        System.out.println("Booth1 leaderBoard: "+tollController.getTollBoothLeaderBoard(toll1, booth1).getTotalAmount());
        System.out.println("Booth2 leaderboard: "+tollController.getTollBoothLeaderBoard(toll1, booth2).getTotalAmount());

        // Scan Pass
        tollController.scanPass(pass2, "tv2", toll1);
        tollController.updateLeaderBoard(booth2, pass2);

        // Print out leader board
        System.out.println("Toll1 leaderboards: "+ tollController.getTollLeaderBoard(toll1).getTotalAmount());
        System.out.println("Booth1 leaderBoard: "+tollController.getTollBoothLeaderBoard(toll1, booth1).getTotalAmount());
        System.out.println("Booth2 leaderboard: "+tollController.getTollBoothLeaderBoard(toll1, booth2).getTotalAmount());

        // Scan Pass
        tollController.scanPass(pass3, "fv1", toll2);
        tollController.updateLeaderBoard(booth3, pass3);

        // Print out leader board
        System.out.println("Toll2 leaderboards: "+ tollController.getTollLeaderBoard(toll2).getTotalAmount());
        System.out.println("Booth3 leaderBoard: "+tollController.getTollBoothLeaderBoard(toll2, booth3).getTotalAmount());
        System.out.println("Booth4 leaderboard: "+tollController.getTollBoothLeaderBoard(toll2, booth4).getTotalAmount());

        // Scan Pass
        tollController.scanPass(pass4, "fv2", toll2);
        tollController.updateLeaderBoard(booth3, pass4);

        // Print out leader board
        System.out.println("Toll2 leaderboards: "+ tollController.getTollLeaderBoard(toll2).getTotalAmount());
        System.out.println("Booth3 leaderBoard: "+tollController.getTollBoothLeaderBoard(toll2, booth3).getTotalAmount());
        System.out.println("Booth4 leaderboard: "+tollController.getTollBoothLeaderBoard(toll2, booth4).getTotalAmount());

        // Again try to scan single pass which is already expired
        tollController.scanPass(pass1, "tv1", toll1);

        // Scan different pass with different vehicle
        tollController.scanPass(pass2, "fv1", toll1);

        // Scan pass in different toll
        tollController.scanPass(pass4, "fv2", toll1);
    }
}
