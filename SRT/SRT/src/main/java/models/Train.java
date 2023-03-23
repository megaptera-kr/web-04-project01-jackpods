package models;

public class Train {
    private String trainName;
    private int departureHour;
    private String departureMinute;

    public Train(String trainName, int departureHour, String departureMinute) {
        this.trainName = trainName;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getDepartureHour() {
        return departureHour;
    }

    public String getDepartureMinute() {
        return departureMinute;
    }

}
