/*
// AUTHOR: Aryan Mitharwal
// FILENAME: Assignment4.java
// SPECIFICATION: User inputs positive integers that will be filed and properly output.
// FOR: CS 1400 - ASSIGNMENT #4
// TIME SPENT: HOW LONG IT TOOK YOU TO FINISH THIS ASSIGNMENT
//*/

import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        System.out.println("Enter a positive integer. Enter -1 to quit.");

        int num;
        while (true) {
            num = input.nextInt();
            if (num == -1) {
                break;
            }

            if (isPrime(num)) {
                System.out.println("The number " + num + " is a prime number.");
                System.out.println("\nEnter a positive integer. Enter -1 to quit.");
            } else {
                System.out.println("The number " + num + " is not a prime number.");
                System.out.println("\nEnter a positive integer. Enter -1 to quit.");
            }

            // Update max, min, sum, and count
            max = Math.max(max, num);
            min = Math.min(min, num);
            sum += num;
            count++;
        }

        if (count > 0) {
            double avg = average(sum, count);
            System.out.println("The maximum positive number is: " + max);
            System.out.println("The minimum positive number is: " + min);
            System.out.println("The sum is: " + sum);
            System.out.println("The count of number(s) is: " + count);
            System.out.printf("The average is: %.2f%n", avg);
        } else {
            System.out.println("No positive integers were entered.");
        }

        input.close();
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double average(int sum, int count) {
        return (double) sum / count;
    }
}