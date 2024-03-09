package com.pg.controller.impl;

import java.sql.SQLException;

import com.pg.controller.StudentController;
import com.pg.dto.Student;
import com.pg.factory.StudentServiceFactory;
import com.pg.service.StudentService;

public class StudentControllerImpl implements StudentController {
	
	@Override
	public int insertRecord(Student student) throws SQLException {

		StudentService service = StudentServiceFactory.getStudentService();
		return service.insertRecord(student);
	}
	
}
