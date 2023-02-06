package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gcu.business.SecurityService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
/**
 * Security Configurations
 * @author ivangudino
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	//security service
	SecurityService service;
	
	
	@Override
	/**
	 * This method configures the security settings
	 */
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
			.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/api/**").authenticated()
				.and()
		    .authorizeRequests()
		        .antMatchers("/", "/about", "/listing", "/register").permitAll()
		        .antMatchers("/images/**", "/css/*", "/js/**").permitAll()
		        .anyRequest().authenticated()
		        .and()
		        .formLogin()
		        .loginPage("/login")
		        .usernameParameter("credentials.username")
		        .passwordParameter("credentials.password")
		        .permitAll()
		        .defaultSuccessUrl("/dashboard", true)
		        .and()
		     .logout()
		        .logoutUrl("/logout")
		        .invalidateHttpSession(true)
		        .clearAuthentication(true)
		        .permitAll()
		        .logoutSuccessUrl("/");
	}
	
	@Autowired
	/**
	 * This method encrypts the passwords.
	 */
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
