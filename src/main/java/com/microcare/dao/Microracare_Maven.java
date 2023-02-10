package com.microcare.dao;

import java.time.LocalDate;

public class Microracare_Maven {

	public static void main(String[] args) {
		DatabaseConnection dc =new DatabaseConnection();
	//Employee emp =dc.getEmployee(75);
//	System.out.println(emp.getFirst_name());
	//	emp.setFirst_name("Kurnool");
	//System.out.println(dc.updateEmployee(emp));
	
	System.out.println(dc.deleteEmployee("georgia.mills@gmail.com"));
		

	}

}
