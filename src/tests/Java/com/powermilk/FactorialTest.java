package com.powermilk;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@DisplayName("Testing Factorial class")
@SelectPackages("com.powermilk")
class FactorialTest {

    private static Logger log = LoggerFactory.getLogger(FactorialTest.class);

    @BeforeAll
    static void setup() {
        log.info("--- Test suite for Factorial class started! ---");
    }

    @BeforeEach
    void init() {
        log.info("Test started!");
    }

    @AfterAll
    static void finish() {
        log.info("--- Test suite for Factorial class finished! ---");
    }

    @AfterEach
    void tearDown() {
        log.info("Test finished!");
    }

    @Test
    @DisplayName("Test should returns a sum of digits for small number as input")
    void shouldReturnSumOfDigitsSmallNumberAsInput() {
        int expected = 3;
        int actual = Factorial.sumOfDigits(5);

        assertAll("Many assertions", () -> assertEquals(expected, actual,
                () -> "The expected is " + expected + " while actual is " + actual));

        log.info("Test for sum of digits for small number as input passed!");
    }

    @Test
    @DisplayName("Test should returns a sum of digits for big number as input")
    void shouldReturnSumOfDigitsBigNumberAsInput() {
        int expected = 207;
        int actual = Factorial.sumOfDigits(45);

        assertAll("Many assertions", () -> assertEquals(expected, actual,
                () -> "The expected is " + expected + " while actual is " + actual));

        log.info("Test for sum of digits for big number as input passed!");
    }

    @Test
    @DisplayName("Test throws IllegalArgumentException for negative as input")
    void shouldThrowsIllegalArgumentExceptionForNegativeAsInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Factorial.sumOfDigits(-1));

        assertEquals(exception.getMessage(), "Argument must be non-negative number!");

        log.info("Test for negative as input passed!");
    }

    @Test
    @DisplayName("Test returns 1 for 0 as input")
    void shouldReturnOneForZeroAsInput() {
        assertEquals(Factorial.sumOfDigits(0), 1);

        log.info("Test for 0 as input passed!");
    }

    @Test
    @DisplayName("Test returns 1 for 1 as input")
    void shouldReturnOneForOneAsInput() {
        assertEquals(Factorial.sumOfDigits(1), 1);

        log.info("Test for 1 as input passed!");
    }
}