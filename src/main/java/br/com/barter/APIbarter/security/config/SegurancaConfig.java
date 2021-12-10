package br.com.barter.APIbarter.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@ConfigurationProperties(prefix = "dados")

public class SegurancaConfig extends WebSecurityConfigurerAdapter{	
	
	@Value("${dados.admin.user}")
	private String user;
	@Value("${dados.admin.pass}")
	private String pass;
	@Value("${dados.user.user}")
	private String userName;
	@Value("${dados.user.pass}")
	private String userPass;
		
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {		
		return super.authenticationManager();
	}		
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication()
			
		.withUser(user).password(pass).roles("ADMIN")
							  //admin426
		.and()
		
		.withUser(userName).password(userPass).roles("ADMIN");
								    //compasso
		
	}	//datos de usuario final para autenticarse en la API y poder con ambas credenciales
		//generar el token y enviarlo junto a cada peticion Http	
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//permissoes -----------------------------------------------------------	
	@Override
    public void configure(WebSecurity webSecurity) throws Exception {
<<<<<<< HEAD
	   
       webSecurity.ignoring().antMatchers("/categorias/api/v1/all");       
       webSecurity.ignoring().antMatchers("/categorias/api/v1/delete/**"); //para angular
       
       webSecurity.ignoring().antMatchers("/produtos/api/v1/all");     
       webSecurity.ignoring().antMatchers("/produtos/api/v1/delete/**"); //para angular
=======
       webSecurity.ignoring().antMatchers("/categorias/api/v1/all");
       webSecurity.ignoring().antMatchers("/categorias/api/v1/find/**");
       
       webSecurity.ignoring().antMatchers("/produtos/api/v1/all");
       webSecurity.ignoring().antMatchers("/produtos/api/v1/find/**");
       
       webSecurity.ignoring().antMatchers("/usuarios/api/v1/all");
       webSecurity.ignoring().antMatchers("/usuarios/api/v1/find/**");
>>>>>>> 9112c598c787cfff5681bf32fc07c4d5734cf90e
       
       webSecurity.ignoring().antMatchers("/usuarios/api/v1/all");     
       webSecurity.ignoring().antMatchers("/usuarios/api/v1/delete/**"); //para angular
              
       webSecurity.ignoring().antMatchers("/v2/api-docs",
               "/configuration/ui",
               "/swagger-resources/**",
               "/configuration/security",
               "/swagger-ui.html",
               "/webjars/**");       
    }	    
	//-----------------------------------------------------------------------
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                .antMatchers("/usuarios/api/v1/allASC").hasRole("ADMIN")                
	                .and()
	                .formLogin();
	}

}
