package models;

import java.util.ArrayList;

public class User {
    private String id;
    private String password;
    private final ArrayList<String> seatList = new ArrayList<>();
    private int sumNumber = 0;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
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

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void transferEdit(String text) {

    }
}
