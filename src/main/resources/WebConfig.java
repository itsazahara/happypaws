import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class WebConfig {
	
	 @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	          registry.addMapping("/**") // Aplica a todas las rutas
	                  .allowedOrigins("http://localhost:4200") // Permite solicitudes desde Angular
	                  .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
	                  .allowedHeaders("*") // Permite cualquier cabecera
	                  .allowCredentials(true); // Permite enviar cookies (si es necesario)
	      }
	    };
	  }

}
