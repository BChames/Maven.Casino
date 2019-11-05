package io.zipcoder.casino.utilities;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class Console {

        public static void print(String output, Object... args) {
            System.out.printf(output, args);
        }

        public static void println(String output, Object... args) {
            print(output + "\n", args);
        }

        public static String getStringInput(String prompt) {
            Scanner scanner = new Scanner(System.in);
            println(prompt);
            String userInput = scanner.nextLine();
            return userInput;
        }

        public static Integer getIntegerInput(String prompt) {
            Scanner scanner = new Scanner(System.in);
            println(prompt);
            Integer userInputInt = scanner.nextInt();
            return userInputInt;
        }

        public static Double getDoubleInput(String prompt) {
            Scanner scanner = new Scanner(System.in);
            println(prompt);
            Double userInputDouble = scanner.nextDouble();
            return userInputDouble;
        }

}

