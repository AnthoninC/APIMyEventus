package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="controller")
public class MyEventusApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEventusApiApplication.class, args);
	}
	
}