package edu.depaul.cdm.se452.RightOfWayRentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class RightOfWayRentalsApplication {

	@Scheduled(fixedDelay = 200000L)
	void healthz() {
		System.out.println("ROWR: I am running!");
	}

	public static void main(String[] args) {
		SpringApplication.run(RightOfWayRentalsApplication.class, args);
	}

}
