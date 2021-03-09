package land.kalee.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		//.allowedOrigins("http://wiki.kalee.land", "http://wiki.kalee.land:80", "http://localhost")
		.allowedMethods("GET", "POST", "DELETE", "PUT");
	}
}
