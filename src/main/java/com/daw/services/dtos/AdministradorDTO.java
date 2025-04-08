package com.daw.services.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdministradorDTO {

	private Integer id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String email;
	private String telefono;
	private String imagen;

}
