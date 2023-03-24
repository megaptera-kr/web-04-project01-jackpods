package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    @Test
    void test() {
        Reservation reservation = new Reservation("1");
        reservation.transfer("기차번호1","오후 2시 출발", "오후 2시 40분 도착");

        assertEquals("기차번호1",reservation.getTrainName());
        assertEquals("오후 2시 출발",reservation.getDepartureTime());
        assertEquals("오후 2시 40분 도착",reservation.getArriveTimes());
    }

}