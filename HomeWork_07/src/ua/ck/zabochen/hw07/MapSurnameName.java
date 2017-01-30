package ua.ck.zabochen.hw07;

/*
    Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
    Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapSurnameName {

    private static final int NUMBER_OF_RECORDS = 10;
    private static MapSurnameName mapSurnameName;

    private MapSurnameName() {
    }

    public static MapSurnameName getInstance() {
        if (mapSurnameName == null) {
            mapSurnameName = new MapSurnameName();
        }
        return mapSurnameName;
    }

    public Map<String, String> getMapSurnameName() {
        return new TreeMap<String, String>() {
            {
                Random random = new Random();
                for (int i = 0; i < NUMBER_OF_RECORDS; i++) {
                    put("Surname_" + i, "Name_" + random.nextInt(10));
                }
            }
        };
    }

    public int getNumberOfSurnameMatches(Map<String, String> map, String surname) {
        int count = 0;
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (m.getKey().equals(surname)) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfNameMatches(Map<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (m.getValue().equals(name)) {
                count++;
            }
        }
        return count;
    }


}
