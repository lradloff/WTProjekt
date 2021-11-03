package htw.berlin.webtech.WTProjekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WtProjektApplication {

	//@Autowired
	//private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(WtProjektApplication.class, args);
	}

}
