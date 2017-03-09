package org.sid;





import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
public class WebMVCConfig  extends WebMvcConfigurerAdapter{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/error").setViewName("error");
        registry.addViewController("/").setViewName("Acceuil.html");
		
		registry.addRedirectViewController("/", "/Acceuil.html");
		
		
	}
	
}
