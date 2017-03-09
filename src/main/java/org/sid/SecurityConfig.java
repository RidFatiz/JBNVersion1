package org.sid;

import javax.sql.DataSource;

import org.sid.service.UserRestService;
//import org.sid.services.UserServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;



@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(securedEnabled=true)

public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	 
	


@Autowired 
	UserRestService userDetailsSeervice ;
	
@Autowired
  DataSource dataSource;
	@Autowired
	public void configAuthentification(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	} 
	
	
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource datasource)throws Exception{
		//ici les utilisateur sont ajouter manuellement  
		
		//on précise ou se trouve les utilisateurs dans la base de données
		auth.jdbcAuthentication()
		      .dataSource(datasource)
		        .usersByUsernameQuery("select username as principal, password as credentials, true from users where username = ?")
				 .authoritiesByUsernameQuery("select users.username as principal,  users.role as role from users where users.username =  ?")
				  .rolePrefix("ROLE_");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        
		
		 http
		 // disable CSRF (as below) or alternatively add some HTML to the page to enable CSRF.
		  .csrf().disable() 
		// OEmbedController#embedTrack uses an iframe
		  .headers().frameOptions().disable()               
         
		 .and()
		 // disable CSRF (as below) or alternatively add some HTML to the page to enable CSRF.
		
		// OEmbedController#embedTrack uses an iframe
		             
         
		 
		 .authorizeRequests()
		 
		 
		// This is here to ensure that the static content (JavaScript, CSS, etc)
	       // is accessible from the login page without authentication
		       .antMatchers("/css/**","/js/**","/image/**","/fonts/**","/","/angular/**")
		       .permitAll()
		       .antMatchers("/css/**","/js/**","/image/**","/fonts/**","/Accueil.html","/inscription.html","/forgetPassword.html","/offreRoute/**","/cvthequeroute/**","/updatepasswordforget","/MailUpdatePassword")		       
		       .permitAll()
		       //.antMatchers("/favicon.ico").permitAll()
		      .antMatchers("/Candidat/**" ).hasRole("Candidat")
		      .antMatchers("/user/**" ).anonymous()
		       .antMatchers("/Recruteur/**" ).hasRole("Recruteur")
                 .anyRequest()																				
		         .authenticated()
		       
		         .and()
				  // access-denied-page: this is the page users will be
			         // redirected to when they try to access protected areas.
			            .exceptionHandling()
			            .accessDeniedPage( "/error" ) 
			 
		         .and()
				   .formLogin()
				          .loginPage("/login")
				          .permitAll()
				          .usernameParameter("username")
				  		  .passwordParameter("password")
				          .defaultSuccessUrl("/index")
				          .failureUrl( "/login?error" )
				       
				        .and()
				        
				   .logout()
				          .invalidateHttpSession(true)
				          .deleteCookies( "JSESSIONID" )
				         // .logoutUrl("/login?out=1")
				          .logoutSuccessUrl( "/login?logout" )
				          .permitAll()
				    
				          .and()
				          .rememberMe()
				          .rememberMeParameter("remember-me")
				          .tokenRepository(persistentTokenRepository()).tokenValiditySeconds(1209600)
				  		
				          
				          ;
				          
				          
				         
		         
		 /*.and()
		 
		 
		 .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
		 
		 .csrf().csrfTokenRepository(csrfTokenRepository());
		
*/
		  // access-denied-page: this is the page users will be
	         // redirected to when they try to access protected areas.
	            
	            
	            
		  
		    
		 
		 }
	



	private CsrfTokenRepository csrfTokenRepository() {
		  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		  repository.setHeaderName("X-XSRF-TOKEN");
		  return repository;
		}
	
	@Bean(name="passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
	
	
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return tokenRepositoryImpl;
	}
	
	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler 
                savedRequestAwareAuthenticationSuccessHandler() {
		
               SavedRequestAwareAuthenticationSuccessHandler auth 
                    = new SavedRequestAwareAuthenticationSuccessHandler();
		auth.setTargetUrlParameter("targetUrl");
		return auth;
	}	
	
	
	

}
