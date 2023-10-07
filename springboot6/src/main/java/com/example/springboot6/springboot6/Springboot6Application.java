package com.example.springboot6.springboot6;

import com.example.springboot6.springboot6.Repo.WeekRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot6Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot6Application.class, args);
	}

/*
	@Bean // Used for testing Ignore
	CommandLineRunner commandLineRunner(WeekRepo weekRepo) {
		// (ArtRepo artRepo)
		return args -> {
			/*


			for (int j=0; j<2; j++){
				String i = "test1";
				Art art7 = new Art(
						i,
						i,
						i
				);
				artRepo.save(art7);
				j++;
			}


			// Info from Week Controllers go in here


		};
	} */


}
