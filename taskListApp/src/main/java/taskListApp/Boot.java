package taskListApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages ="com.taskList.service")
@EnableJpaRepositories(basePackages = "com.taskList.repository")
@EntityScan(basePackages = "com.taskList.model")
public class Boot {
	
	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

}
