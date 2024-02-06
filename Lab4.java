/*-------------------------------------------------------------
// AUTHOR: Aryan Mitharwal
// FILENAME: Lab4.java
// SPECIFICATION: User inputs an option and measurements for the program to "draw".
// FOR: CS 1400- Lab #4
// TIME SPENT: 45 minutes
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        final char SIDE_SYMB = '-';
        final char MID_SYMB = '*';
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        char choice = ' ';
        int numSymbols = -1, sideWidth = -1, midWidth = -1;

        do {
            displayMenu();
            inputStr = scanner.next();
            if (inputStr.length() > 0) {
                choice = inputStr.charAt(0);
            }

            switch (choice) {
                case 'r':
                    System.out.println("Width of the sides: ");
                    sideWidth = scanner.nextInt();
                    System.out.println("Width of the middle: ");
                    midWidth = scanner.nextInt();

                    System.out.println();
                    System.out.print(buildRow(SIDE_SYMB, sideWidth, MID_SYMB, midWidth));

                    break;
                case 'p':
                    System.out.println("Number of symbols on the lowest layer: ");
                    numSymbols = scanner.nextInt();

                    System.out.println();
                    System.out.print(buildPyramid(SIDE_SYMB, MID_SYMB, numSymbols));

                    break;
                case 'd':
                    System.out.println("Number of symbols on the middle layer: ");
                    numSymbols = scanner.nextInt();

                    System.out.println();
                    System.out.print(buildDiamond(SIDE_SYMB, MID_SYMB, numSymbols));

                    break;
                case 'q':
                    System.out.println("Bye");
                    break;

                default:
                    System.out.println("Please choose a valid option from the menu.");
                    break;
            }
            System.out.println();
        } while (choice != 'q');

        scanner.close();

    } // End of main

    public static String buildRow(char sideSymb, int sideWidth, char midSymb, int midWidth)
 {
        StringBuilder result = new StringBuilder();

        // Build one side
        for (int i = 0; i < sideWidth; i++) {
            result.append(sideSymb);
        }

        // Build the middle part
        for (int i = 0; i < midWidth; i++) {
            result.append(midSymb);
        }

        // Build the other side
        for (int i = 0; i < sideWidth; i++) {
            result.append(sideSymb);
        }

        result.append('\n'); // Add a newline character at the end

        return result.toString();
    }

    public static String buildPyramid(char sideSymb, char midSymb, int numSymbols)
 {
        StringBuilder result = new StringBuilder();
        int ptnHeight = (numSymbols % 2 == 0) ? numSymbols - 1 : numSymbols;

        // If numSymbols is 0, return an empty string
        if (ptnHeight == 0) {
            return "";
        }

        // Make a loop to iterate the pyramid's levels
        for (int i = 1; i <= ptnHeight; i += 2) {
            int sideWidth = (ptnHeight - i) / 2;
            int midWidth = i;

            // Use the "buildRow" method to make a row and append it to the result
            result.append(buildRow(sideSymb, sideWidth, midSymb, midWidth));
        }

        return result.toString();
    }

    public static String buildDiamond(char sideSymb, char midSymb, int numSymbols)
 {
        StringBuilder result = new StringBuilder();

        // If numSymbols is 0, return an empty string
        if (numSymbols == 0) {
            return "";
        }

        // Make the upper part of the diamond
        for (int i = 1; i <= numSymbols; i += 2) {
            int sideWidth = (numSymbols - i) / 2;
            int midWidth = i;

            // Use the "buildRow" method to make a row and append it to the result
            result.append(buildRow(sideSymb, sideWidth, midSymb, midWidth));
        }

        // Make the lower part of the diamond (inverted)
        for (int i = numSymbols - 2; i >= 1; i -= 2) {
            int sideWidth = (numSymbols - i) / 2;
            int midWidth = i;

            // Use the "buildRow" method to make a row and append it to the result
            result.append(buildRow(sideSymb, sideWidth, midSymb, midWidth));
        }

        return result.toString();
    }

    private static void displayMenu() {
        System.out.println("Please choose one pattern from the list");
        System.out.println("r) Row");
        System.out.println("p) Pyramid");
        System.out.println("d) Diamond");
        System.out.println("q) Quit");
    }
}
