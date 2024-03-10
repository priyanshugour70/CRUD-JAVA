package com.pg;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pg.controller.StudentController;
import com.pg.dto.Student;
import com.pg.factory.StudentControllerFactory;

public class Main {

	// main() : driver code
	public static void main(String[] args) {

		StudentController controller = StudentControllerFactory.getStudentControllerObj();
		Student student = new Student();

		System.out.println(
			"Welcome to CRUD Application\n"+
			"Author : Priyanshu Gour\n"+
			"Date : " + new Date(System.currentTimeMillis()) + "\n"+
			"====================================================\n"
		);
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
				"Enter 0 to display single Student"+
				"Enter 1 to display all Students\n"+
				"Enter 2 to insert new Student\n"+
				"Enter 3 to update Student\n"+
				"Enter 4 to delete Student\n"+
				"Enter [any other] to exit\n"
			);

			String choice = sc.next();
			try{
				if(choice.equals("0")) {
					// display single student
	                System.out.print("Enter student ID to view details: ");
	                int studentIdToView = sc.nextInt();

	                try {
	                    Student retrievedStudent = controller.getStudentById(studentIdToView);
	                    if (retrievedStudent != null) {
	                        System.out.println("\nStudent Details:\n");
	                        System.out.println("Student ID: " + retrievedStudent.getSid());
	                        System.out.println("Name: " + retrievedStudent.getSname());
	                        System.out.println("Age: " + retrievedStudent.getSage());
	                        System.out.println("Address: " + retrievedStudent.getSaddress());
	                        System.out.println("Class: " + retrievedStudent.getSclass());
	                        System.out.println("Date of Birth: " + retrievedStudent.getSdob());
	                        System.out.println("\n------------------------------\n");
	                    } else {
	                        System.out.println("\nNo matching records found.\n");
	                    }
	                } catch (SQLException e) {
	                    // Handle the exception appropriately
	                    e.printStackTrace();
	                }
				}else if(choice.equals("1")){
					// display all records
					try {
					    List<Student> students = controller.getAllStudents();
					    if (students.isEmpty()) {
					        System.out.println("No records found.");
					    } else {
					        System.out.println("Student Records:\n");
					        for (Student stud : students) {
					            System.out.println("Student ID: " + stud.getSid());
					            System.out.println("Name: " + stud.getSname());
					            System.out.println("Age: " + stud.getSage());
					            System.out.println("Address: " + stud.getSaddress());
					            System.out.println("Class: " + stud.getSclass());
					            System.out.println("Date of Birth: " + stud.getSdob());
					            System.out.println("\n------------------------------\n");
					        }
					    }
					} catch (SQLException e) {
					    // Handle the exception appropriately
					    e.printStackTrace();
					}
				}else if(choice.equals("2")){
					// insert new record
					System.out.print("Enter student name: ");
					student.setSname(sc.next());
					
					System.out.print("Enter student ID: ");
					student.setSid(sc.nextInt());
			
					System.out.print("Enter student age: ");
					student.setSage(sc.nextInt());
			
					System.out.print("Enter student address: ");
					student.setSaddress(sc.next());
			
					System.out.print("Enter student class: ");
					student.setSclass(sc.next());
			
					System.out.print("Enter student date of birth (YYYY-MM-DD): ");
					// Assuming the user enters the date in 'YYYY-MM-DD' format
					student.setSdob(Date.valueOf(sc.next()));

					try {
						System.out.println("No of records inserted is :: " + controller.insertRecord(student));
					} catch (SQLException e) {
						// we will create our own exception
						System.out.println("Insertion failure....");
					}
				}else if(choice.equals("3")){
					// update record
				}else if(choice.equals("4")){
					// delete record
					if (choice.equals("4")) {
					    System.out.print("Enter student ID to delete: ");
					    int studentIdToDelete = sc.nextInt();

					    try {
					        int deletedRecords = controller.deleteRecord(studentIdToDelete);
					        if (deletedRecords > 0) {
					            System.out.println("\nRecord deleted successfully.\n");
					        } else {
					            System.out.println("\nNo matching records found for deletion.\n");
					        }
					    } catch (SQLException e) {
					        // Handle the exception appropriately
					        e.printStackTrace();
					    }
					    System.out.println("\n------------------------------\n");
					}
				}else{
					break;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		System.out.println(
			"====================================================\n"+
			"Thank you for using CRUD Application\n"+
			"Visit again\n"+
			"====================================================\n"
		);

		// closing scanner
		sc.close();
	}

}
