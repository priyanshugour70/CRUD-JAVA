package com.pg.service;

import java.sql.SQLException;

import com.pg.dto.Student;

public interface StudentService {

	
	// C -> Create
	// R -> Read
	// U -> Update
	// D -> Delete

	public int insertRecord(Student student) throws SQLException;
	
	
}
