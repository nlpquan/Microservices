package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()
@ComponentScan({"com.gcu"})
/**
 * This is the main application that runs
 * @author ivangudino
 *
 */
public class MilestoneApplication {
	/**
	 * This method is the main method
	 * @param args args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MilestoneApplication.class, args);
	}

}
