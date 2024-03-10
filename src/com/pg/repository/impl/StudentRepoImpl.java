package com.pg.repository.impl;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pg.dto.Student;
import com.pg.repository.StudentRepo;
import com.pg.utility.JdbcUtil;

public class StudentRepoImpl implements StudentRepo{
	
	private static Connection connection = null ;
	
	static {
		try {
			connection = JdbcUtil.getDBConection();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Student getStudentById(int studentId) throws SQLException {
	    Statement statement = null;
	    ResultSet resultSet = null;
	    Student student = null;

	    try {
	        if (connection != null) {
	            statement = connection.createStatement();
	            String sqlSelectQuery = "SELECT * FROM student WHERE sid = " + studentId;
	            resultSet = statement.executeQuery(sqlSelectQuery);

	            if (resultSet.next()) {
	                student = new Student();
	                student.setSid(resultSet.getInt("sid"));
	                student.setSname(resultSet.getString("sname"));
	                student.setSage(resultSet.getInt("sage"));
	                student.setSaddress(resultSet.getString("saddress"));
	                student.setSclass(resultSet.getString("sclass"));
	                student.setSdob(resultSet.getDate("sdob"));
	            }
	        }
	    } finally {
	        // Ensure that resources are closed (e.g., statement, resultSet)
	        if (statement != null) {
	            statement.close();
	        }
	        if (resultSet != null) {
	            resultSet.close();
	        }
	    }

	    return student;
	}
	
	
	@Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sqlSelectQuery = "SELECT * FROM student";
                resultSet = statement.executeQuery(sqlSelectQuery);

                while (resultSet.next()) {
                    Student student = new Student();
                    student.setSid(resultSet.getInt("sid"));
                    student.setSname(resultSet.getString("sname"));
                    student.setSage(resultSet.getInt("sage"));
                    student.setSaddress(resultSet.getString("saddress"));
                    student.setSclass(resultSet.getString("sclass"));
                    student.setSdob(resultSet.getDate("sdob"));

                    students.add(student);
                }
            }
        } finally {
            // Ensure that resources are closed (e.g., statement, resultSet)
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return students;
    }
	
	
    @Override
    public int insertRecord(Student student) throws SQLException {

        Statement statement = null;

        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sqlInsertQuery = String.format("INSERT INTO student (sid, sname, sage, saddress, sclass, sdob) VALUES(%d, '%s', %d, '%s', '%s', '%s')", student.getSid(), student.getSname(), student.getSage(), student.getSaddress(), student.getSclass(), student.getSdob());
                System.out.println(sqlInsertQuery + "\n");

                if (statement != null && sqlInsertQuery != null) {
					try{
						return statement.executeUpdate(sqlInsertQuery);
					}catch(Exception e){
						// we will create our own exception
						e.printStackTrace();
					}
                }
            }
        } finally {
            // Ensure that resources are closed (e.g., statement)
            if (statement != null) {
                statement.close();
            }
        }

        return 0;
    }
    
    
    @Override
    public int deleteRecord(int studentId) throws SQLException {
        Statement statement = null;

        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sqlDeleteQuery = "DELETE FROM student WHERE sid = " + studentId;
                return statement.executeUpdate(sqlDeleteQuery);
            }
        } finally {
            // Ensure that resources are closed (e.g., statement)
            if (statement != null) {
                statement.close();
            }
        }

        return 0;
    }
}
