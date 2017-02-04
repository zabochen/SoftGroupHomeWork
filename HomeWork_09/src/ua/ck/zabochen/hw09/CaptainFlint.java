package ua.ck.zabochen.hw09;

/*
    Капитан Флинт зарыл клад на Острове сокровищ. Он оставил описание, как найти клад. Описание состоит из строк вида:
    "North 5", где слово – одно из "North", "South", "East", "West", – задает направление движения,
    а число – количество шагов, которое необходимо пройти в этом направлении.
    Напишите программу, которая по описанию пути к кладу определяет точные координаты клада, считая, что начало
    координат находится в начале пути, ось OX направлена на восток, ось OY – на север.

    North - Север    A
    South - Юг       V
    East  - Восток  -->
    West  - Запад   <--
*/

import java.util.Random;

public class CaptainFlint {

    private final String[] EARTH_CORNERS = {"North", "South", "East", "West"};

    public String getTasks(int tasksNumber) {
        final int RANDOM_STEPS_RANGE = 30;
        Random random = new Random();

        StringBuilder steps = new StringBuilder();
        for (int i = 0; i < tasksNumber; i++) {
            if (i == (tasksNumber - 1)) {
                steps.append(EARTH_CORNERS[random.nextInt(EARTH_CORNERS.length)] + " " + random.nextInt(RANDOM_STEPS_RANGE));
            } else {
                steps.append(EARTH_CORNERS[random.nextInt(EARTH_CORNERS.length)] + " " + random.nextInt(RANDOM_STEPS_RANGE) + ", ");
            }
        }

        return steps.toString();
    }

    public String[] getTreasureCoordinates(String tasks) {
        String[] taskArray = tasks.split(",");
        String[] coordinates = new String[taskArray.length];

        for (int i = 0; i < taskArray.length; i++) {
            String step = taskArray[i].trim();

            switch (step.charAt(0)) {
                case 'E':
                    coordinates[i] = step + " -> X: " + Integer.parseInt(step.replace(EARTH_CORNERS[2], "").trim()) + ", Y: 0";
                    break;
                case 'W':
                    coordinates[i] = step + " -> X: " + -Integer.parseInt(step.replace(EARTH_CORNERS[3], "").trim()) + ", Y: 0";
                    break;
                case 'N':
                    coordinates[i] = step + " -> X: 0, " + "Y: " + Integer.parseInt(step.replace(EARTH_CORNERS[0], "").trim());
                    break;
                case 'S':
                    coordinates[i] = step + " -> X: 0, " + "Y: " + -Integer.parseInt(step.replace(EARTH_CORNERS[1], "").trim());
                    break;
            }
        }

        return coordinates;
    }

}
