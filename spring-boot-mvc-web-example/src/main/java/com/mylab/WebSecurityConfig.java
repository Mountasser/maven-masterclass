package com.mylab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetailsServiceImpl;
	
	
	/**
	 * Configure Spring security url filters and login logout Spring Security
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/pizzas","/info","/addPizza").hasAnyRole("USER","ADMIN").and()
		.authorizeRequests().antMatchers("/users","/addUser").hasRole("ADMIN").and()
		.authorizeRequests().antMatchers("/static/**","/logout","/login").permitAll();
		
	    http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll();
		
		http.logout().logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll();
		
		
		http.sessionManagement().maximumSessions(1).expiredUrl("/?expired").maxSessionsPreventsLogin(true).and()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
//        .invalidSessionUrl("/?invalid");
	}

	/**
	 * Configure global security with Bccyptenoncder and custom userDetailService with Spring Security
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	
	/**
	 * Bcrypt password encoding configuration, more info at http://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
