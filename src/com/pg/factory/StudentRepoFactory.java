package com.pg.factory;

import com.pg.repository.StudentRepo;
import com.pg.repository.impl.StudentRepoImpl;

public class StudentRepoFactory {
	
	private static StudentRepoImpl studentRepo = null;

	private StudentRepoFactory() {

	}

	// Singleton pattern
	public static StudentRepo getStudentRepo() {
		if (studentRepo == null) {
			studentRepo = new StudentRepoImpl();
		}
		return studentRepo;
	}

}
