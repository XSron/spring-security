package springsecurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
@ComponentScan("springsecurity.controller")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser(users.username("admin").password("123").roles("ADMIN", "CEO"))
				.withUser(users.username("sale").password("321").roles("SALE"))
				.withUser(users.username("it").password("111").roles("IT"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//.anyRequest().authenticated() 
			.antMatchers("/").hasAnyRole("ADMIN", "SALE", "IT")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/sale/**").hasRole("SALE")
			.antMatchers("/it/**").hasRole("IT")
			.and()
			.formLogin().loginPage("/authentication") 
						.loginProcessingUrl("/authenticate") 
						.permitAll() 
			.and()
			.logout()
			.logoutSuccessUrl("/authentication")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied"); 
	}
	
	
}
