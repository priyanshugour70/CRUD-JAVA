package com.pg.factory;

import com.pg.controller.StudentController;
import com.pg.controller.impl.StudentControllerImpl;

public class StudentControllerFactory {

	private static StudentController controller = null;

	public static StudentController getStudentControllerObj() {
		if (controller == null) {
			controller = new StudentControllerImpl();
		}
		return controller;
	}	

}
