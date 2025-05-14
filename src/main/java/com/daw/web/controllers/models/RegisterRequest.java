package com.daw.web.controllers.models;

import com.daw.persistence.entities.enumerados.TipoVivienda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	private String nombre;

	private String apellidos;

	private String usuario;

	private String contrasenia;

	private String email;

	private String direccion;

	private Integer edad;

	private String telefono;

	private String ocupacionLaboral;

	private TipoVivienda tipoVivienda;

	private Boolean otrasMascotas;

	private Boolean experienciaMascotas;

	private String observaciones;

	private String imagen;

}
