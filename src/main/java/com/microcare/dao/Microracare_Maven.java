package com.microcare.dao;

public class Microracare_Maven {

	public static void main(String[] args) {
		DatabaseConnection dc =new DatabaseConnection();
		System.out.println(dc.getEmployee(20).toString());

	}

}
