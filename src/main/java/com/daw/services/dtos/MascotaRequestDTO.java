package com.daw.services.dtos;

import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.persistence.entities.enumerados.Tamanio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MascotaRequestDTO {
	
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
    private Integer idRaza;

}
