package ua.ck.zabochen.hw07;

import java.util.Date;
import java.util.Map;

public class HomeWork07 {

    public static void main(String[] args) {

        // MapSurnameName
        System.out.println("Map -> [Key:Surname, Value:Name]");
        Map<String, String> mapSurnameName = MapSurnameName.getInstance().getMapSurnameName();
        printMapSurnameName(mapSurnameName);
        System.out.println("\nSurname Matches -> \"Surname_1\" -> " + MapSurnameName.getInstance().getNumberOfSurnameMatches(
                mapSurnameName,
                "Surname_1"
        ));
        System.out.println("Name Matches -> \"Name_1\" -> " + MapSurnameName.getInstance().getNumberOfNameMatches(
                mapSurnameName,
                "Name_1"
        ));

        System.out.println("\n");

        // MapSurnameDate
        System.out.println("Map -> [Key:Surname, Value:Birthday]");
        Map<String, Date> mapSurnameDate = MapSurnameDate.getInstance().getMapSurnameDate();
        printMapSurnameDate(mapSurnameDate);
        System.out.println("\nRemove Summer People -> June, July, August:");
        System.out.println("\nMap -> [Key:Surname, Value:Birthday]");
        MapSurnameDate.getInstance().removeSummerPeople(mapSurnameDate);
        printMapSurnameDate(mapSurnameDate);
    }

    private static void printMapSurnameName(Map<String, String> mapSurnameName) {
        for (Map.Entry<String, String> m : mapSurnameName.entrySet()) {
            System.out.println(m.getKey() + ", " + m.getValue());
        }
    }

    private static void printMapSurnameDate(Map<String, Date> mapSurnameDate) {
        for (Map.Entry<String, Date> m : mapSurnameDate.entrySet()) {
            System.out.println(m.getKey() + ", " + m.getValue());
        }
    }

}
