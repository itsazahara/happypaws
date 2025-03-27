package com.daw.services.dtos;

import java.time.LocalDateTime;

import com.daw.persistence.entities.enumerados.Tamanio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CitaDTO {
	
	private Integer id;
    private LocalDateTime fechaHora;
    private String nombrePeluquero;
    private String emailPeluquero;
    private String nombreMascota;
    private Tamanio tamanio;

}
