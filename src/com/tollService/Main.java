package com.tollService;

import com.tollService.controllers.TollController;
import com.tollService.models.LeaderBoard;
import com.tollService.models.Pass;
import com.tollService.models.ReturnPass;
import com.tollService.models.SinglePass;
import com.tollService.models.Toll;
import com.tollService.models.TollBooth;
import com.tollService.models.TwoWheelVehicle;
import com.tollService.models.Vehicle;
import com.tollService.services.TollService;
import com.tollService.services.VehicleService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        VehicleService vehicleService = new VehicleService();
        TollService tollService = new TollService(vehicleService);
        Toll toll = new Toll("1");
        TollBooth tollBooth = new TollBooth("11");
        TollBooth tollBooth12 = new TollBooth("12");
        tollService.addTollBooth(toll, tollBooth);
        tollService.addTollBooth(toll, tollBooth12);

        TollController tollController = new TollController(tollService);

        Pass pass = new SinglePass(toll, tollBooth);
        Pass pass1 = new ReturnPass(toll, tollBooth);
        Vehicle vehicle = new TwoWheelVehicle("v1", 1.0, pass);
        Vehicle vehicle1 = new TwoWheelVehicle("v2", 2.0, pass1);

        tollController.addPass(pass, "v1", vehicle);
        tollController.addPass(pass1, "v2", vehicle1);

        System.out.println(tollController.validatePass("v2", tollBooth,toll));
        System.out.println(tollController.validatePass("v2",tollBooth, toll));
        System.out.println(tollController.validatePass("v2",tollBooth, toll));
        LeaderBoard leaderBoard = tollController.getTollLeaderBoard(toll, tollBooth);
        System.out.println(leaderBoard.getNumberOfVehicles());
        System.out.println(leaderBoard.getTotalAmount());

        Pass pass3 = new SinglePass(toll, tollBooth12);
        Vehicle vehicle3 = new TwoWheelVehicle("v3", 1.0, pass);

        tollController.addPass(pass3, "v3", vehicle3);

        System.out.println(tollController.validatePass("v3", tollBooth,toll));
        System.out.println(tollController.validatePass("v3",tollBooth, toll));
        LeaderBoard leaderBoard2 = tollController.getTollLeaderBoard(toll, tollBooth12);
        System.out.println(leaderBoard2.getNumberOfVehicles());
        System.out.println(leaderBoard2.getTotalAmount());
    }
}
