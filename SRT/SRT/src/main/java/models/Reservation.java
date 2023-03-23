package models;

public class Reservation {
    private int departureHour = 0;

    private String number;
    private String trainCode = "";
    private int arriveHour = 0;
    private int arriveMinute = 0;



    public Reservation(String number) {
        this.number = number;
    }

    public void transferInformation( int arriveHour, int arriveMinute) {
        this.arriveHour = arriveHour;
        this.arriveMinute = arriveMinute;
    }

    public int getArriveHour() {
        return arriveHour;
    }

    public int getArriveMinute() {
        return arriveMinute;
    }


    public void transfer(String trainCode) {
        this.trainCode = trainCode;
    }
}
