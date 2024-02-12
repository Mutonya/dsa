package org.example;

import java.util.Scanner;
//Given an input string, reverse the string word by word.
public class StringReversal {
    public static String reverseWords(String inputString) {
        String[] words = inputString.trim().split("\\s+");
        StringBuilder reversedWordsBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedWordsBuilder.append(words[i]);
            if (i > 0) {
                reversedWordsBuilder.append(" ");
            }
        }
        return reversedWordsBuilder.toString();
    }

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Input string for reversal");

        String userName = myObj.nextLine();  // Read user input
        String result = reverseWords(userName);
        System.out.println(result);
    }
}

