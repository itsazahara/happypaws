package com.daw.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

	private final JwtFiltro jwtFiltro;
	private final AuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.cors(cors -> cors.configurationSource(request -> new org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues()))
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(publicEndpoints()).permitAll()
						.requestMatchers("/api/**").permitAll().requestMatchers("/razas/**").permitAll()
						.requestMatchers("/reservas/**").permitAll().requestMatchers("/mascotas/**").permitAll()
						.requestMatchers("/clientes/**").permitAll().requestMatchers("/administradores/**").permitAll()
						.requestMatchers("/auth/authenticate", "/auth/register").permitAll()
						.requestMatchers("/auth/authenticateAdmin", "/auth/registerAdmin").permitAll()
						.requestMatchers("/administradores/holaSeguro").hasRole("ADMINISTRADOR")
						.requestMatchers("/clientes/holaSeguro").hasRole("USUARIO").anyRequest().authenticated())
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtFiltro, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}

	private RequestMatcher publicEndpoints() {
		return new OrRequestMatcher(new AntPathRequestMatcher("/auth/**"));
	}

}