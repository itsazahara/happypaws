package com.daw.services.dtos;

import com.daw.persistence.entities.enumerados.TipoVivienda;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String telefono;
	private String email;
	private String direccion;
	private Integer edad;
	private String ocupacionLaboral;
	private TipoVivienda tipoVivienda;
	private Boolean otrasMascotas;    
	private Boolean experienciaMascotas;
	private String observaciones;
	private String imagen;

}
