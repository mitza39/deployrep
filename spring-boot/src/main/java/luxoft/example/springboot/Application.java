package luxoft.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class,args);
		String [] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		//Arrays.stream(beanNames).forEach(System.out::println);


		//SpringApplication.run(Application.class, args);
	}

}
