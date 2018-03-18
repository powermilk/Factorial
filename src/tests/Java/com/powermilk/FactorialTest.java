package com.powermilk;

import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("Test should returns a sum of digits for small factorial value as input")
    void shouldReturnSumOfDigitsSmallNumberAsInput() {
        int expected = 3;
        int actual = Factorial.sumOfDigits(5);

        assertAll("Many assertions",() -> {
            assertEquals(expected, actual,
                    () -> "The expected is " + expected + " while actual is " + actual);
        });

        log.info("Test passed!");
    }

    @Test
    @DisplayName("Test should returns a sum of digits for big factorial value as input")
    void shouldReturnSumOfDigitsBigNumberAsInput() {
        int expected = 207;
        int actual = Factorial.sumOfDigits(45);

        assertAll("Many assertions",() -> {
            assertEquals(expected, actual,
                    () -> "The expected is " + expected + " while actual is " + actual);
        });

        log.info("Test passed!");
    }

    @Test
    @DisplayName("Test throws IllegalArgumentException for negative as input")
    void shouldThrowIllegalArgumentExceptionForNegativeAsInput() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.sumOfDigits(-1);
        });

        assertEquals(exception.getMessage(), "Argument must be non-negative number!");

        log.info("Test passed!");
    }
}