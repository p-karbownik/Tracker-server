package pl.edu.pw.pik.pikactivitytrackerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PikactivityTrackerServerApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(PikactivityTrackerServerApplication.class, args);
	}

}
