package models;

public class TemporaryStorage {

    private String regionName = "";
    public TemporaryStorage() {

    }

    public void transfer(String regionName) {
        this.regionName = regionName;
    }

    public String getEditRegionName() {
        return regionName;
    }
}
