package br.com.technews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class TechnewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnewsApplication.class, args);
	}

	@Configuration
	public class WebConfiguration implements WebMvcConfigurer {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**").allowedMethods("*");
			}
	}

}
