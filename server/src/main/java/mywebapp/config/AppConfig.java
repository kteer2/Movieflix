package mywebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableTransactionManagement
@ComponentScan({"mywebapp.data.setup","mywebapp.validator","org.springframework.security","mywebapp.config","mywebapp.services","mywebapp.controllers","mywebapp.repository","mywebapp.entity","mywebapp.facades"})
@EnableWebMvc
@Import({ SecurityConfig.class })
public class AppConfig {

	 @Bean
	    public UrlBasedViewResolver urlBasedViewResolver()
	    {
	        UrlBasedViewResolver res = new InternalResourceViewResolver();
	        res.setViewClass(JstlView.class);
	        res.setPrefix("/WEB-INF/views/");
	        res.setSuffix(".jsp");

	        return res;
	    }
}