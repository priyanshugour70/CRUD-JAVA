package com.pg.controller.impl;

import java.sql.SQLException;
import java.util.List;

import com.pg.controller.StudentController;
import com.pg.dto.Student;
import com.pg.factory.StudentServiceFactory;
import com.pg.service.StudentService;

public class StudentControllerImpl implements StudentController {
	
	private final StudentService service = StudentServiceFactory.getStudentService();
	
	@Override
    public Student getStudentById(int studentId) throws SQLException {
        return service.getStudentById(studentId);
    }
	
    @Override
    public List<Student> getAllStudents() throws SQLException {
        return service.getAllStudents();
    }
	
	@Override
	public int insertRecord(Student student) throws SQLException {
		return service.insertRecord(student);
	}
	
    @Override
    public int deleteRecord(int studentId) throws SQLException {
        return service.deleteRecord(studentId);
    }
}
