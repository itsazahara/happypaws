package com.daw.services.mappers;

import com.daw.persistence.entities.Mascota;
import com.daw.services.dtos.MascotaRequestDTO;

public class MascotaRequestMapper {
	
	public static Mascota toEntity(MascotaRequestDTO dto) {
        Mascota mascota = new Mascota();
        
        mascota.setId(dto.getId());
        mascota.setNombre(dto.getNombre());
        mascota.setSexo(dto.getSexo());
        mascota.setEspecie(dto.getEspecie());
        mascota.setTamanio(dto.getTamanio());
        mascota.setEdad(dto.getEdad());
        mascota.setPeso(dto.getPeso());
        mascota.setEsterilizado(dto.getEsterilizado());
        mascota.setVacunado(dto.getVacunado());
        mascota.setDesparasitado(dto.getDesparasitado());
        mascota.setPersonalidad(dto.getPersonalidad());
        mascota.setImagen(dto.getImagen());
        mascota.setCuidadosEspeciales(dto.getCuidadosEspeciales());
        mascota.setHistoria(dto.getHistoria());
        mascota.setDisponibilidad(dto.getDisponibilidad());
        mascota.setIdRaza(dto.getIdRaza());
        
        return mascota;
    }

}
