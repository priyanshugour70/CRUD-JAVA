package com.pg.factory;

import com.pg.service.StudentService;
import com.pg.service.impl.StudentServiceImpl;

public class StudentServiceFactory {

	private static StudentService studentService = null;

	private StudentServiceFactory() {

	}

	public static StudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
	
}
