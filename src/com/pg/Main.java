package com.pg;

import com.pg.ui.PersonUI;
import com.pg.ui.StudentUI;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {
        printWelcomeStudentMessage();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                printMenuOptions();
                if (sc.hasNextInt()) { // Check if there is an integer input
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 0:
                            new StudentUI();
                            break;
                        case 1:
                            new PersonUI();
                            break;
                        default:
                            closeApplication();
                            return; // Exit the program if an invalid choice is entered
                    }
                } else {
                    String input = sc.next(); // Consume the invalid input
                    System.out.println("Invalid input: " + input + ". Please enter a valid integer.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private static void printWelcomeStudentMessage() {
        System.out.println("Welcome to CRUD Application");
        System.out.println("Author: Priyanshu Gour");
        System.out.println("Date: " + new Date(System.currentTimeMillis()));
        System.out.println("====================================================\n");
    }

    private static void printMenuOptions() {
        System.out.println("Enter 0 to Student Module");
        System.out.println("Enter 1 to Person Module");
        System.out.println("Enter [any other] to exit\n");
    }

    private static void closeApplication() {
        System.out.println("====================================================\n"
                + "Thank you for using CRUD Application\n" + "Visit again\n"
                + "====================================================\n");
    }
}
