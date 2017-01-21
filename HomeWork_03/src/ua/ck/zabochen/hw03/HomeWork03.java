package ua.ck.zabochen.hw03;

import java.util.Arrays;

public class HomeWork03 {

    private static final int FIBONACCI_SEQUENCE_LENGTH = 4;

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        System.out.println("Fibonacci -> used Array:");
        System.out.println(Arrays.toString(fibonacci.getArraySequence(FIBONACCI_SEQUENCE_LENGTH)));

        System.out.println("\nFibonacci -> used ArrayList:");
        System.out.println(fibonacci.getArrayListSequence(FIBONACCI_SEQUENCE_LENGTH));

        System.out.println("\nFibonacci -> used ArrayList BigInteger:");
        System.out.println(fibonacci.getArrayListBigSequence(FIBONACCI_SEQUENCE_LENGTH));

        System.out.println("\nFibonacci -> used recursion:");
        System.out.println(Arrays.toString(fibonacci.getRecursionSequence(FIBONACCI_SEQUENCE_LENGTH)));

        System.out.println("\nVampire Numbers:");
        VampireNumbers vampireNumbers = new VampireNumbers();
        int[] multiplyNumbers = new int[2];
        for (int i = 1000; i < 10000; i++) {
            if (vampireNumbers.isVampire(i, multiplyNumbers)) {
                System.out.println(i + " => " + multiplyNumbers[0] + " * " + multiplyNumbers[1]);
            }
        }
    }

}
