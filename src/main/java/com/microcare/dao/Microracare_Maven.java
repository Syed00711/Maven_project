package com.microcare.dao;

import java.time.LocalDate;

public class Microracare_Maven {

	public static void main(String[] args) {
		DatabaseConnection dc =new DatabaseConnection();
		//System.out.println(dc.getEmployees().size());
		
		//dc.getEmployees().forEach(System.out::println);
		
		Employee ee =new Employee();
		
		ee.setFirst_name("Microcare");
		ee.setLast_name("Academy");
		ee.setPhone("2378947298374");
		ee.setJob_title("Trainee");
		ee.setHire_date(LocalDate.now());
		ee.setEmail("micro.aca@gmail.com");
		ee.setSalary(72417L);
		System.out.println(dc.insertEmployee(ee));
		

	}

}
