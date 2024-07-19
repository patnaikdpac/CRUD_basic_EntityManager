package com.deepak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHibernateCruDwoDaoApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoHibernateCruDwoDaoApplication.class, args);
		System.out.println("This project will demonstrate the CRUD application without the use of DAO");
		
	}

}
