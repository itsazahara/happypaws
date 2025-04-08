package com.daw.services.dtos;

import java.time.LocalDateTime;

import com.daw.persistence.entities.enumerados.Estado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservaDTO {

	private Integer id;
	private MascotaDTO mascotas;
	private ClienteDTO clientes;
	private AdministradorDTO administradores;
	private Estado estado;
	private String observaciones;
	private LocalDateTime fechaSolicitud;

}
