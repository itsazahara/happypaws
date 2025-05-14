package com.daw.web.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAdminRequest {
	
	private String nombre;

	private String apellidos;

	private String usuario;

	private String contrasenia;

	private String email;

	private String telefono;

	private String imagen;

}
