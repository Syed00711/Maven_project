package com.microcare.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
	
	private static final String url="jdbc:oracle:thin:@microcareacademydb_high?TNS_ADMIN=/Users/sh030348/Downloads/Wallet_MicrocareAcademyDB";
    private static final String username="ADMIN";
    private static final String password="Muzammil073#";
    
    
    private static String instemp="insert into employees values((select max(employee_id)+1 from employees),"
    		+ "FIRST_NAME,LAST_NAME,EMAIL,PHONE,HIRE_DATE,10,JOB_TITLE,SALARY)";
    
   // private static String udpemployee ="update employees set FIRST_NAME=?,LAST_NAME=LT where employee_id=?"
    
    private  Connection conn;
    
    static {
    	try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	}
    	catch(ClassNotFoundException cnfe) {
    		cnfe.printStackTrace();
    	}
    }
    
    
    public int insertEmployee(Employee emp) {
    	
    	int result=0;
try {
	
	if(emp!=null) {
		instemp =instemp.replace("FIRST_NAME", "'"+emp.getFirst_name()+"'")
		.replace("LAST_NAME", "'"+emp.getLast_name()+"'")
		.replace("EMAIL", "'"+emp.getEmail()+"'")
		.replace("PHONE", "'"+emp.getPhone()+"'")
		.replace("HIRE_DATE","sysdate")
		.replace("JOB_TITLE", "'"+emp.getJob_title()+"'").replace("SALARY",Long.toString(emp.getSalary()));
		System.out.println(instemp);
            
			Statement stmt =getConnection().createStatement();
		result =stmt.executeUpdate(instemp);
			
	}
			
} catch (SQLException e) {
	e.printStackTrace();
}finally {
	closeConnection();
}	
		return result;
    	
    }
    
    
    public List<Employee> getEmployees(){
    	List<Employee> employees = new ArrayList<Employee>();
          Employee emp;
		
		try {
            
			Statement stmt =getConnection().createStatement();
		ResultSet rs =stmt.executeQuery("select * from employees");			
			while(rs.next()) {
				emp=new Employee();
				emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				emp.setFirst_name(rs.getString("FIRST_NAME"));
				emp.setLast_name(rs.getString("LAST_NAME"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setJob_title(rs.getString("JOB_TITLE"));
				emp.setHire_date(rs.getDate("HIRE_DATE").toLocalDate());
				emp.setManager_id(rs.getInt("MANAGER_ID"));
				employees.add(emp);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
return employees;
    	
    	
    }
    
    
    
	public  Employee getEmployee(int emp_id) {
		
		Employee emp =new Employee();
		
		try {
            
			Statement stmt =getConnection().createStatement();
		ResultSet rs =stmt.executeQuery("select * from employees where employee_id="+emp_id);			
			while(rs.next()) {
				emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
				emp.setFirst_name(rs.getString("FIRST_NAME"));
				emp.setLast_name(rs.getString("LAST_NAME"));
				emp.setPhone(rs.getString("PHONE"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setJob_title(rs.getString("JOB_TITLE"));
				emp.setHire_date(rs.getDate("HIRE_DATE").toLocalDate());
				emp.setManager_id(rs.getInt("MANAGER_ID"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
return emp;
	}
	
	
	public  Connection getConnection() {
		try {
            conn = DriverManager.getConnection(url, 
					username, password);
	} catch (SQLException e) {
		e.printStackTrace();	
	}
return conn;
	}
	
	public  void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
