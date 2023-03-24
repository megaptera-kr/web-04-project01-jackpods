package models;

public class Region {

    private String region;
    private int distance;

    public Region(String region, int distance) {
        this.region = region;

        this.distance = distance;
    }

    public String getRegion() {
        return region;
    }

    public int getDistance() {
        return distance;
    }

}
