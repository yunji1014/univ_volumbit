package UNIV.volumbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "UNIV.volumbit.model") // <- 명시적으로 지정
//@EnableJpaRepositories(basePackages = "UNIV.volumbit.repository")
public class VolumbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolumbitApplication.class, args);
	}
}
