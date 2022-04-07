package ntnu.group10.backend.group10;

import ntnu.group10.backend.group10.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Group10Application {

	public static void main(String[] args) {
		SpringApplication.run(Group10Application.class, args);
	}

}
