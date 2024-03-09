package com.pg.service.impl;

import java.sql.SQLException;

import com.pg.dto.Student;
import com.pg.factory.StudentRepoFactory;
import com.pg.repository.StudentRepo;
import com.pg.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public int insertRecord(Student student) throws SQLException {
		
		//abstraction
		StudentRepo repo = StudentRepoFactory.getStudentRepo();
		return repo.insertRecord(student);
		
	}
	


}
