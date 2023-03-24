package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {
    @Test
    void regionText() {
        Region region = new Region("천안",80);
        assertEquals("천안", region.getRegion());

    }

    @Test
    void distanceText() {
        Region region = new Region("천안",80);
        assertEquals(80, region.getDistance());

    }
}