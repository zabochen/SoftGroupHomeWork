package ua.ck.zabochen.hw10;

import java.util.List;
import java.util.Scanner;

public class HomeWork10 {

    public static void main(String[] args) {

        System.out.println("-= Split string =-\n");
        System.out.println("Source text:\n" + SplitString.TEXT + "\n");
        System.out.println("Result:");
        List<String> splitString = SplitString.get(SplitString.TEXT, 20);
        for (String s : splitString) {
            System.out.println(s);
        }

        System.out.println("\n-= Palindrome =-\n");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type a words of 5 letters:");
            Palindrome.checkWord(scanner.nextLine());
        }
    }

}
