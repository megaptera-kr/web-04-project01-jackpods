package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test() {
        User user = new User("jack","1234");
        user.send(10);
        user.minusSum();
        assertEquals(9,user.getSumNumber());
    }

}