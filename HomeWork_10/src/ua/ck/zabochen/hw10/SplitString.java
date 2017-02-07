package ua.ck.zabochen.hw10;

import java.util.ArrayList;
import java.util.List;

/*
    Дана строка. Разбить строку, не разрывая слова, на подстроки таким образом, чтобы в каждой строке количество
    символов не превышало заданное.
*/

public class SplitString {

    public static final String TEXT = "Дана строка. Разбить строку, не разрывая слова, на подстроки.";

    public static List<String> get(String text, int lineLength) {
        final String[] words = text.split(" ");
        List<String> lines = new ArrayList<>();

        int countWords = 0;
        int countLineLength = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while (countWords < words.length) {
            if ((countLineLength + words[countWords].length()) <= lineLength) {
                countLineLength += words[countWords].length() + 1; // +1 Space
                stringBuilder.append(words[countWords])
                        .append(" ");
                countWords++;
            } else {
                lines.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                countLineLength = 0;
            }
        }

        // End of String
        if (stringBuilder.length() > 0) {
            lines.add(stringBuilder.toString());
        }

        return lines;
    }

}
