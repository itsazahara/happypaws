package com.daw.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFiltro extends OncePerRequestFilter{
	
	private final UserDetailsService userDetailsService;
	private final jwtService jwtService;
	
	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// HttpServletRequest request es lo que el cliente nos envía en la petición
		// HttpServletResponse response es lo que nosotros le vamos a entregar al cliente una vez procesada la solicitud
		// FilterChain filterChain elemento que nos permite continuar con el proceso de la solicitud una vez que la hayamos filtrado
		
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String username;
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt = authHeader.substring(7);
		username = jwtService.getUserName(jwt);
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(jwtService.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
