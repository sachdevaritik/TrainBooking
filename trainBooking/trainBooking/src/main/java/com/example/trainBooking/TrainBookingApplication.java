package com.example.trainBooking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainBookingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrainBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println( "To access all functionality please refer controller");
	}

}
