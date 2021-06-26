package com.tollService.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class WeekPass extends Pass {

    private Date validUpTo;

    public WeekPass(Toll toll, TollBooth booth, Vehicle vehicle) {
        super(toll, booth, vehicle);
        this.validUpTo = new Date();
        this.status = PassStatus.VALID;
    }

    private Date setValidUpTo() {
        Date newDate = new Date();
        LocalDateTime.from(newDate.toInstant()).plusDays(7);
        return newDate;
    }
    @Override
    public boolean isValidPass(Pass pass, Toll toll){
        return (pass.status==PassStatus.VALID && pass.getToll().equals(toll));
    }

    public void updatePass(Pass pass){
        Date currentDate = new Date();
        if(this.validUpTo.before(currentDate)){
            this.setStatus(PassStatus.EXPIRED);
        }
    }
}
