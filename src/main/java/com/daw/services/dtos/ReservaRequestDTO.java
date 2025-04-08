package com.daw.services.dtos;

import com.daw.persistence.entities.enumerados.Estado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReservaRequestDTO {

	private Integer idMascota;
	private Integer idCliente;
	private Integer idAdministrador;
	private Estado estado;
	private String observaciones;

}
