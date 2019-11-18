package co.edu.uniajc.wse_bodega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WsePersonasApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder
	configure(SpringApplicationBuilder application) {
		return application.sources(WsePersonasApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WsePersonasApplication.class, args);
	}

}
