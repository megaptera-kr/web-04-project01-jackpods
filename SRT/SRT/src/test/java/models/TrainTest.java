package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {
        @Test
    void test(){
            Train train = new Train("1234",3,"4");

            assertEquals("1234",train.getTrainName());
            assertEquals(3,train.getDepartureHour());
            assertEquals("4",train.getDepartureMinute());
        }
}