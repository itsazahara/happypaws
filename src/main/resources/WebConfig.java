import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@ComponentScan
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	 @Bean
	  public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	    config.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
	    config.setAllowedHeaders(Arrays.asList("*"));
	    
	    UrlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);
	    retorun source;
	  }

}
