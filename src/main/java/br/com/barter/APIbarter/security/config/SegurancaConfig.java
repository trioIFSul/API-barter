package br.com.barter.APIbarter.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SegurancaConfig extends WebSecurityConfigurerAdapter{	
			
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {		
		return super.authenticationManager();
	}		
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication()
		.withUser("hector").password("$2a$10$drMTtQW0b8SDH9fmC/v/3eg43Jl4BxjqM/G/gyFApl8LN1T9euak6").roles("ADMIN")		
									//admin426
		.and()
		.withUser("richard").password("$2a$10$Xas7ChbS6Rb9ncUz/RldBej8EK4zLpfE8eMTLTjyNpG6CmUGLJXMa").roles("USER");		
								//admin123
	}	//datos de usuario final para autenticarse en la API y poder con ambas credenciales
		//generar el token y enviarlo junto a cada peticion Http	
		
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//permissoes -----------------------------------------------------------	
	@Override
    public void configure(WebSecurity webSecurity) throws Exception {
       webSecurity.ignoring().antMatchers("/categorias/api/v1/all");
       //webSecurity.ignoring().antMatchers("/categorias/api/v1/allASC");
      // webSecurity.ignoring().antMatchers("/categorias/api/v1/allDEC");
       webSecurity.ignoring().antMatchers("/categorias/api/v1/find/**");
       
       webSecurity.ignoring().antMatchers("/produtos/api/v1/all");
      // webSecurity.ignoring().antMatchers("/produtos/api/v1/allASC");
      // webSecurity.ignoring().antMatchers("/produtos/api/v1/allDEC");
       webSecurity.ignoring().antMatchers("/produtos/api/v1/find/**");
       
       webSecurity.ignoring().antMatchers("/usuarios/api/v1/all");
      // webSecurity.ignoring().antMatchers("/usuarios/api/v1/allASC");
      // webSecurity.ignoring().antMatchers("/usuarios/api/v1/allDEC");
       webSecurity.ignoring().antMatchers("/usuarios/api/v1/find/**");
       
       webSecurity.ignoring().antMatchers("/v2/api-docs",
               "/configuration/ui",
               "/swagger-resources/**",
               "/configuration/security",
               "/swagger-ui.html",
               "/webjars/**");       
    }	    
	//-----------------------------------------------------------------------

}
