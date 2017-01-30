package ua.ck.zabochen.hw07;

/*
    Создать словарь (Map<String, Birthday>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
    Удалить из словаря всех людей, родившихся летом.
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MapSurnameDate {

    private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    private static final int NUMBER_OF_RECORDS = 10;

    private static MapSurnameDate mapSurnameDate;

    private MapSurnameDate() {
    }

    public static MapSurnameDate getInstance() {
        if (mapSurnameDate == null) {
            mapSurnameDate = new MapSurnameDate();
        }
        return mapSurnameDate;
    }

    public Map<String, Date> getMapSurnameDate() {
        return new TreeMap<String, Date>() {
            {
                try {
                    Random random = new Random();
                    DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy");
                    for (int i = 0; i < NUMBER_OF_RECORDS; i++) {
                        put("Surname_" + i, dateFormat.parse(MONTHS[random.nextInt(12)] + " 8, 1980"));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void removeSummerPeople(Map<String, Date> mapSurnameDate) {
        Calendar calendar = Calendar.getInstance();
        Iterator<Map.Entry<String, Date>> iterator = mapSurnameDate.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> map = iterator.next();
            calendar.setTime(map.getValue());
            int month = calendar.get(Calendar.MONTH);
            // Summer: June, July, August
            if (month >= 5 && month <= 7) {
                iterator.remove();
            }
        }
    }

}
