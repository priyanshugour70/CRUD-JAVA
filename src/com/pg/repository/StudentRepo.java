package com.pg.repository;

import java.sql.SQLException;
import java.util.List;

import com.pg.dto.Student;

public interface StudentRepo {
	

	// C -> Create
	// R -> Read
	// U -> Update
	// D -> Delete
	
	Student getStudentById(int studentId) throws SQLException;

	List<Student> getAllStudents() throws SQLException;
	
	public int insertRecord(Student student) throws SQLException;
	
	int updateStudent(int studentId, Student updatedStudent) throws SQLException;
	
	int deleteRecord(int studentId) throws SQLException;

}
