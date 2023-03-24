package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlCenterTest {
    @Test
    void distance30() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
//        String regionName, String day, int estimatedTimeHour, int estimatedTimeMinute
        controlCenter.transfer(30);
        assertEquals(10, controlCenter.getEstimatedMinute());
    }

    @Test
    void distance60() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
//        String regionName, String day, int estimatedTimeHour, int estimatedTimeMinute
        controlCenter.transfer(60);
        assertEquals(20, controlCenter.getEstimatedMinute());
    }

    @Test
    void distance80() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
//        String regionName, String day, int estimatedTimeHour, int estimatedTimeMinute
        controlCenter.transfer(80);
        assertEquals(33, controlCenter.getEstimatedMinute());
    }

    @Test
    void distance90() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
//        String regionName, String day, int estimatedTimeHour, int estimatedTimeMinute
        controlCenter.transfer(90);
        assertEquals(46, controlCenter.getEstimatedMinute());
    }

    @Test
    void distance120() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
//        String regionName, String day, int estimatedTimeHour, int estimatedTimeMinute
        controlCenter.transfer(120);
        assertEquals(55, controlCenter.getEstimatedMinute());
    }

    @Test
    void adultCount() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
        controlCenter.getAdultCount();
        controlCenter.plusAdultCount();
        assertEquals(2, controlCenter.getAdultCount());
    }

    @Test
    void childrenCount() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
        controlCenter.getChildrenCount();
        controlCenter.plusChildrenCount();
        assertEquals(2, controlCenter.getPassengerSum());
    }


    @Test
    void personSum() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
        controlCenter.getAdultCount();
        controlCenter.plusAdultCount();
        controlCenter.getChildrenCount();
        controlCenter.plusChildrenCount();
        controlCenter.getChildCount();
        controlCenter.plusChildCount();

        assertEquals(4, controlCenter.getPassengerSum());
    }

    @Test
    void personSumAll() {
        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
        controlCenter.getAdultCount();
        controlCenter.plusAdultCount();
        controlCenter.getChildrenCount();
        controlCenter.plusChildrenCount();
        controlCenter.getChildCount();
        controlCenter.plusChildCount();
        controlCenter.getOldManCount();
        controlCenter.plusOldManCount();

        assertEquals(5, controlCenter.getPassengerSum());
    }

    @Test
    void priceSum() {
//         int sum = (int) (price * adultCount + price * childrenCount * 0.25 + price * childCount * 0.5 + price * oldManCount * 0.75);
//        return sum;

        ControlCenter controlCenter = new ControlCenter("천안", "21", 2, 0);
        Region region = new Region("천안",80);
    }
}