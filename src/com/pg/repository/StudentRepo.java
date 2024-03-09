package com.pg.repository;

import java.sql.SQLException;

import com.pg.dto.Student;

public interface StudentRepo {
	

	// C -> Create
	// R -> Read
	// U -> Update
	// D -> Delete

	public int insertRecord(Student student) throws SQLException;

}
