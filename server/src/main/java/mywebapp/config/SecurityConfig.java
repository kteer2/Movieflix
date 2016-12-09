package mywebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.csrf().disable().authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/welcome").hasAnyRole("ADMIN","USER")	
		.antMatchers("/registration").permitAll()
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("/login")
			.loginProcessingUrl("/login").defaultSuccessUrl("/welcome")
			.failureUrl("/login?error").usernameParameter("username").passwordParameter("password").permitAll()
			.and()
		.logout()
			.logoutSuccessUrl("/login?logout").permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
	
	 @Bean(name="authenticationManager")
	   @Override
	   public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	   }
	 
	 @Bean(name="bCryptPasswordEncoder")
	 public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
		 
	 }
	 

}
