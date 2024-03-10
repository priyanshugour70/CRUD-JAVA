package com.pg.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.pg.dto.Student;
import com.pg.factory.StudentRepoFactory;
import com.pg.repository.StudentRepo;
import com.pg.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	// Declare repo at the class level
    private final StudentRepo repo = StudentRepoFactory.getStudentRepo();
    
    
    @Override
    public Student getStudentById(int studentId) throws SQLException {
        return repo.getStudentById(studentId);
    }
	
    @Override
    public List<Student> getAllStudents() throws SQLException {
        return repo.getAllStudents();
    }

	@Override
	public int insertRecord(Student student) throws SQLException {
		return repo.insertRecord(student);
		
	}
	
    @Override
    public int updateStudent(int studentId, Student updatedStudent) throws SQLException {
        return repo.updateStudent(studentId, updatedStudent);
    }
	
    @Override
    public int deleteRecord(int studentId) throws SQLException {
        return repo.deleteRecord(studentId);
    }
	


}
