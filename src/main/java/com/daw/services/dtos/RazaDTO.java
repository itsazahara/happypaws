package com.daw.services.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RazaDTO {
	
	private Integer id;
	private String nombre;
	private List<MascotaDTO> mascotas;

}
