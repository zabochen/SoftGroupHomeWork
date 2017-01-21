package ua.ck.zabochen.hw03;

/*
    Fibonacci sequence - every number after the first two is the sum of the two preceding ones:
    1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, ...
 */

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

    // Array

    public int[] getArraySequence(int sequenceLength) {

        if (sequenceLength > 0) {
            int f1;
            int f2;
            int[] fibonacciArraySequence = new int[sequenceLength];

            for (int i = 0; i < sequenceLength; i++) {
                if (i > 1) {
                    f1 = fibonacciArraySequence[i - 1];
                    f2 = fibonacciArraySequence[i - 2];
                    fibonacciArraySequence[i] = f1 + f2;
                } else {
                    fibonacciArraySequence[i] = 1;
                }
            }

            return fibonacciArraySequence;
        } else {
            System.out.println("The sequence length is wrong.");
            return null;
        }
    }

    // ArrayList<Integer>

    public ArrayList<Integer> getArrayListSequence(int sequenceLength) {

        if (sequenceLength > 0) {
            Integer f1 = 1;
            Integer f2 = 1;
            Integer f;
            ArrayList<Integer> fibonacciArrayListSequence = new ArrayList<>();

            for (int i = 1; i <= sequenceLength; i++) {
                if (i > 2) {
                    f = f1 + f2;
                    f1 = f2;
                    f2 = f;
                    fibonacciArrayListSequence.add(f);
                } else {
                    fibonacciArrayListSequence.add(1);
                }
            }

            return fibonacciArrayListSequence;
        } else {
            System.out.println("The sequence length is wrong.");
            return null;
        }
    }

    // ArrayList<BigInteger>

    public ArrayList<BigInteger> getArrayListBigSequence(int sequenceLength) {

        if (sequenceLength > 0) {
            BigInteger f1 = BigInteger.ONE;
            BigInteger f2 = BigInteger.ONE;
            BigInteger f;
            ArrayList<BigInteger> fibonacciArrayListBigSequence = new ArrayList<>();

            for (int i = 1; i <= sequenceLength; i++) {
                if (i > 2) {
                    f = f1.add(f2);
                    f1 = f2;
                    f2 = f;
                    fibonacciArrayListBigSequence.add(f);
                } else {
                    fibonacciArrayListBigSequence.add(BigInteger.ONE);
                }
            }

            return fibonacciArrayListBigSequence;
        } else {
            System.out.println("The sequence length is wrong.");
            return null;
        }
    }

    // Recursion

    public int recursion(int numberOfSequence) {

        // Ternary operator
        // return numberOfSequence <= 2 ? 1 : recursion(numberOfSequence - 1) + recursion(numberOfSequence - 2);

        if (numberOfSequence == 1 || numberOfSequence == 2) {
            return 1;
        } else {
            return recursion(numberOfSequence - 1) + recursion(numberOfSequence - 2);
        }
    }

    public int[] getRecursionSequence(int sequenceLength) {
        if (sequenceLength > 0) {
            int[] fibonacciArraySequence = new int[sequenceLength];

            for (int i = 0; i < sequenceLength; i++) {
                fibonacciArraySequence[i] = recursion(i + 1);
            }

            return fibonacciArraySequence;
        } else {
            System.out.println("The sequence length is wrong.");
            return null;
        }
    }

}
