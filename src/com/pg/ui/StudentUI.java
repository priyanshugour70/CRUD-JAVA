package com.pg.ui;

import com.pg.controller.StudentController;
import com.pg.dto.Student;
import com.pg.factory.StudentControllerFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentUI {


    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentController controller = StudentControllerFactory.getStudentControllerObj();

    public StudentUI() throws SQLException {
        printWelcomeStudentMessage();

        while (true) {
            printStudentMenuOptions();
            String choice = scanner.next();

            try {
                switch (choice) {
                    case "0":
                        displaySingleStudent();
                        break;
                    case "1":
                        displayAllStudents();
                        break;
                    case "2":
                        insertNewStudent();
                        break;
                    case "3":
                        updateStudent();
                        break;
                    case "4":
                        deleteStudent();
                        break;
                    default:
                        closeStudnetApplication();
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void displaySingleStudent() throws SQLException {
        System.out.print("Enter student ID to view details: ");
        int studentIdToView = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        com.pg.dto.Student retrievedStudent = controller.getStudentById(studentIdToView);
        displayStudentDetails(retrievedStudent);
    }

    private static void displayAllStudents() throws SQLException {
        List<Student> students = controller.getAllStudents();
        for (Student student : students) {
            StudentUI.displayStudentDetails(student);
        }
    }

    private static void insertNewStudent() throws SQLException {
        com.pg.dto.Student newStudent = readStudentDetails();
        int insertedRecords = controller.insertRecord(newStudent);
        System.out.println("No of records inserted is :: " + insertedRecords);
    }

    private static void updateStudent() throws SQLException {
        System.out.print("Enter student ID to update: ");
        int studentIdToUpdate = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        com.pg.dto.Student retrievedStudent = controller.getStudentById(studentIdToUpdate);
        displayStudentDetails(retrievedStudent);

        System.out.print("Do you want to update this student? (yes/no): ");
        String confirmUpdate = scanner.next().toLowerCase();

        if (confirmUpdate.equals("yes")) {
            com.pg.dto.Student updatedStudent = readStudentDetails();
            int updatedRecords = controller.updateStudent(studentIdToUpdate, updatedStudent);
            System.out.println(updatedRecords > 0 ? "\nRecord updated successfully.\n" : "\nNo matching records found for update.\n");
        } else {
            System.out.println("\nOk.. Select Other Operation ...!\n");
        }
    }

    private static void deleteStudent() throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int studentIdToDelete = scanner.nextInt();
        int deletedRecords = controller.deleteRecord(studentIdToDelete);

        System.out.println(deletedRecords > 0 ? "\nRecord deleted successfully.\n" : "\nNo matching records found for deletion.\n");
        System.out.println("\n------------------------------\n");
    }

    private static com.pg.dto.Student readStudentDetails() {
        com.pg.dto.Student student = new com.pg.dto.Student();

        System.out.print("Enter Student sid: ");
        student.setSid(scanner.nextInt());

        System.out.print("Enter student name: ");
        student.setSname(scanner.next());

        System.out.print("Enter student age: ");
        student.setSage(scanner.nextInt());

        System.out.print("Enter student address: ");
        student.setSaddress(scanner.next());

        System.out.print("Enter student class: ");
        student.setSclass(scanner.next());

        System.out.print("Enter student date of birth (YYYY-MM-DD): ");
        student.setSdob(Date.valueOf(scanner.next()));

        return student;
    }

    private static void displayStudentDetails(com.pg.dto.Student student) {
        System.out.println("Student ID: " + student.getSid());
        System.out.println("Name: " + student.getSname());
        System.out.println("Age: " + student.getSage());
        System.out.println("Address: " + student.getSaddress());
        System.out.println("Class: " + student.getSclass());
        System.out.println("Date of Birth: " + student.getSdob());
        System.out.println("\n------------------------------\n");
    }

    private static void printWelcomeStudentMessage() {
        System.out.println("Welcome to Student Module...");
        System.out.println("====================================================\n");
    }

    private static void printStudentMenuOptions() {
        System.out.println("Enter 0 to display single Student");
        System.out.println("Enter 1 to display all Students");
        System.out.println("Enter 2 to insert new Student");
        System.out.println("Enter 3 to update Student");
        System.out.println("Enter 4 to delete Student");
        System.out.println("Enter [any other] to exit\n");
    }

    private static void closeStudnetApplication() {
        System.out.println("====================================================\n"
                + "Thank you for using STUDENT Module\n"
                + "====================================================\n");

        // closing scanner
        scanner.close();
    }

}
