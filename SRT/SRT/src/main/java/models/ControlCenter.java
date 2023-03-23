package models;

//출발지와 도착지를 가지고 있으면 된다.
public class ControlCenter {
    private int price = 0;
    private String regionName;
    private String day;
    private int estimatedTimeHour;
    private int estimatedTimeMinute;

    private int adultCount = 1;
    private int childrenCount = 0;
    private int childCount = 0;
    private int oldManCount = 0;
    private int priceSum = 0;

    public ControlCenter( String regionName, String day, int estimatedTimeHour, int estimatedTimeMinute) {

        this.regionName = regionName;
        this.day = day;

        this.estimatedTimeHour = estimatedTimeHour;
        this.estimatedTimeMinute = estimatedTimeMinute;

    }

    public void transfer(int distance) {
        if (distance == 30) {
            price += 7_000;
            this.estimatedTimeMinute += 10;
        }
        if (distance == 60) {
            price += 9_500;
            this.estimatedTimeMinute += 20;
        }
        if (distance == 80) {
            this.price += 11_300;
            this.estimatedTimeMinute += 33;
        }

        if (distance == 90) {
            this.price += 12_500;
            this.estimatedTimeMinute += 46;
        }

        if (distance == 120) {
            this.price += 20_000;
            this.estimatedTimeHour += 1;
            this.estimatedTimeMinute += 1;
        }
    }

    public int getPrice() {
        return price;
    }

    public void resetPrice() {
        this.price = 0;
    }

    public void send(String region) {
        this.regionName = region;
    }

    public String getRegionName() {
        return regionName;
    }

    public void add(String day) {
        this.day = day;
    }

    public void plusAdultCount() {
        adultCount += 1;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void minusAdultCount() {
        adultCount -= 1;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void minusChildrenCount() {
        childrenCount -= 1;
    }

    public void plusChildrenCount() {
        childrenCount += 1;
    }

    public int getChildCount() {
        return childCount;
    }

    public void minusChildCount() {
        childCount -= 1;
    }

    public void plusChildCount() {
        childCount += 1;
    }

    public int getOldManCount() {
        return oldManCount;
    }

    public void minusOldManCount() {
        oldManCount -= 1;
    }

    public void plusOldManCount() {
        oldManCount += 1;
    }

    public String getReservationDay() {
        return day;
    }


    public int getEstimatedHour() {
        return estimatedTimeHour;
    }

    public int getEstimatedMinute() {
        return estimatedTimeMinute;
    }

    public int getSum() {

        return adultCount + childrenCount + childCount + oldManCount;
    }


    public int getPriceSum() {
        int sum = (int) (price*adultCount + price*childrenCount*0.25 + price*childCount*0.5+price*oldManCount*0.75);
        return sum;
    }
}
