
package com.pulseplayer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PulsePlayerApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(PulsePlayerApplication.class, args);
	}

}
