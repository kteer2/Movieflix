package mywebapp.movieflix;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@ComponentScan
@EnableWebMvc
public class MVCconfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
		.allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers")
        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        .allowCredentials(false).maxAge(3600);
	}	
}
