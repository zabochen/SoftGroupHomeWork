package ua.ck.zabochen.hw09;

public class HomeWork09 {

    public static void main(String[] args) {

        final int TASKS_NUMBER = 10;

        CaptainFlint captainFlint = new CaptainFlint();

        System.out.println("Tasks:");
        String tasks = captainFlint.getTasks(TASKS_NUMBER);
        System.out.println(tasks + "\n");

        System.out.println("Coordinates:");
        String[] coordinates = captainFlint.getTreasureCoordinates(tasks);
        for (int i = 0; i < coordinates.length; i++) {
            System.out.println(coordinates[i]);
        }

    }

}
