package com.pg;

import java.sql.Date;
import java.sql.SQLException;
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
				"Enter 1 to display all records\n"+
				"Enter 2 to insert new record\n"+
				"Enter 3 to update record\n"+
				"Enter 4 to delete record\n"+
				"Enter [any other] to exit\n"
			);

			String choice = sc.next();
			try{
				if(choice.equals("1")){
					// display all records
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
