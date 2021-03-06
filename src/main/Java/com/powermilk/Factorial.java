package com.powermilk;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial {
    static int sumOfDigits(int n) {
        BigInteger number = calcutaleFactional(n);

        if (number == null) {
            throw new NullPointerException("Something went wrong with calculation!");
        }

        return String.valueOf(number)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    private static BigInteger calcutaleFactional(int n) {
        BigInteger result = BigInteger.ONE;
        if(n < 0) {
            throw new IllegalArgumentException("Argument must be non-negative number!");
        }

        if (n > 2) {
            result = IntStream
                    .rangeClosed(2, n)
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger::multiply)
                    .orElse(null);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calcutaleFactional(0));
    }
}
