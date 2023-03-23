package models;

import java.util.ArrayList;

public class User {
    private String name;
    private final ArrayList<String> seatList = new ArrayList<>();
    private int sumNumber = 0;

    public User(String name, String seatNumber) {
        this.name = name;
    }

    public void transfer(String seatNumber) {
        seatList.add(seatNumber);
    }

    public void send(int sumOfPeople) {
        this.sumNumber = sumOfPeople;
    }

    public int getSumNumber() {
        return sumNumber;
    }

    public void minusSum() {
        sumNumber -= 1;
    }

    public ArrayList<String> getSeatList() {
        return seatList;
    }
}
