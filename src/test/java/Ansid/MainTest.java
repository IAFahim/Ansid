package Ansid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test1() {
        Main main = new Main();
        assertEquals("Hello World!", main.test());
    }
}