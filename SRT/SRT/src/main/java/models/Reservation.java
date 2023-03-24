package models;

import java.util.ArrayList;

public class Reservation {

    private String number;
    private String trainCode = "";
    private String departureTime = "";
    private String arriveTimes = "";


    public Reservation(String number) {
        this.number = number;
    }

    public void transfer(String trainCode,String departureTime,String arriveTimes) {
        this.trainCode = trainCode;
        this.departureTime = departureTime;
        this.arriveTimes = arriveTimes;
    }

    public String getTrainName() {
        return trainCode;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArriveTimes() {
        return arriveTimes;
    }
}
