package com.daw.services.dtos;

import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.persistence.entities.enumerados.Tamanio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MascotaDTO {
	
	private Integer id;
    private String nombre;
    private Sexo sexo;
    private Especie especie;
    private Tamanio tamanio;
    private Integer edad;
    private Double peso;
    private Boolean esterilizado;
    private Boolean vacunado;
    private Boolean desparasitado;
    private String personalidad;
    private String imagen;
    private String cuidadosEspeciales;
    private String historia;
    private Boolean disponibilidad;
    private RazaDTO raza;

}
