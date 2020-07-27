package com.java;
import com.java.model.*;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startapp {

	public static void main(String[] args) {
		SpringApplication.run(Startapp.class, args);
		try
		{
		InputReading.mainApl();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
