package com.pg.repository.impl;

import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	

}
