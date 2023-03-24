package models;

import java.util.ArrayList;

public class CompletePayment {

    private String regionName = "";
    private String departureTime = "";
    private String arriveTimes = "";
    private String reservationDay = "";
    private String editRegion;
    private String trainName = "";
    private int priceSum = 0;
    private ArrayList<String> checkedList = new ArrayList<>();
    private ArrayList<String> transactions = new ArrayList<>();

    public CompletePayment() {
    }

    public void transfer(String regionName, String departureTime, String arriveTimes, String reservationDay, String trainName, int priceSum) {

        this.regionName = regionName;
        this.departureTime = departureTime;
        this.arriveTimes = arriveTimes;
        this.reservationDay = reservationDay;
        this.trainName = trainName;
        this.priceSum = priceSum;


       transactions.add("도착역: "+this.regionName);
       transactions.add("출발일: 3월 "+this.reservationDay+"일");
       transactions.add("출발 시간: "+this.departureTime);
       transactions.add("도착 시간: "+this.arriveTimes);
       transactions.add("기차 번호: "+this.trainName);
    }

    public String getRegionName() {
        return regionName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArriveTime() {
        return arriveTimes;
    }

    public String getDepartureDay() {
        return reservationDay;
    }

    public String getTrainNumber() {
        return trainName;
    }

    public int getPriceSum() {
        return priceSum;
    }

    public ArrayList<String> getSeatNumber() {
        return checkedList;
    }

    public  ArrayList<String> getList() {
        return transactions;
    }

    public void transferEdit(String text) {
        this.reservationDay = text;
    }

    public void transfer(String editRegionName) {
        this.regionName = editRegionName;
    }
}
