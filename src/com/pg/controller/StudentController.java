package com.pg.controller;

import java.sql.SQLException;

import com.pg.dto.Student;

public interface StudentController {
	
	// C -> Create
	// R -> Read
	// U -> Update
	// D -> Delete

	public int insertRecord(Student student) throws SQLException;

}
