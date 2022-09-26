package edu.depaul.cdm.se452.RightOfWayRentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class RightOfWayRentalsApplication {

	// for testing - to be removed
	@Scheduled(fixedDelay = 200000L)
	void healths() {
		System.out.println("healthy");

	}

	public static void main(String[] args) {
		SpringApplication.run(RightOfWayRentalsApplication.class, args);
	}

}
