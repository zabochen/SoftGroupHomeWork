package ua.ck.zabochen.hw10;

/*
    Создать программу, которая будет проверять, является ли слово из пяти букв, введённое пользователем, палиндромом
    (примеры: «комок», «ротор»). Если введено слово не из 5 букв, то сообщать об ошибке. Программа должна нормально
    обрабатывать слово, даже если в нём использованы символы разного регистра. Например, слова «Комок» или «РОТОР»
    следует также считать палиндромами.
*/

public class Palindrome {

    public static boolean checkWord(String word) {
        String checkWord = word.toLowerCase();
        if (checkWord.length() == 5) {
            if (checkWord.charAt(0) == checkWord.charAt(4) && checkWord.charAt(1) == checkWord.charAt(3)) {
                System.out.println(word + " -> Palindrome.\n");
                return true;
            } else {
                System.out.println(word + " -> Not palindrome.\n");
                return false;
            }
        } else {
            System.out.println("Input Error!\n");
            return false;
        }
    }

}
