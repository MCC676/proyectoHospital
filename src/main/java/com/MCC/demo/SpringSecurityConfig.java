package com.MCC.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.MCC.demo.models.dao.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JpaUserDetailsService userDetails;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/img/**","/webfonts/**","/menu/","/api/**").permitAll()
		.antMatchers("/pacientes/listar").hasAnyRole("USER")
		.antMatchers("/pacientes/ver/**").hasAnyRole("USER")
		.antMatchers("/pacientes/form").hasAnyRole("ADMIN")
		.antMatchers("/medicos/form").hasAnyRole("ADMIN")
		.antMatchers("/medicamentos/form").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/").permitAll()
		.and()
		.logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
		
		/*PasswordEncoder enconder =	passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password ->{return enconder.encode(password);});
		
		auth.inMemoryAuthentication()
		.withUser(users.username("admin").password("123").roles("ADMIN","USER"))
		.withUser(users.username("marco").password("123").roles("USER"));*/
	}
	
	
	
}
