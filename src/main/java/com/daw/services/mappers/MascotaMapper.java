package com.daw.services.mappers;

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.Raza;
import com.daw.services.dtos.MascotaDTO;

public class MascotaMapper {
	
	public static MascotaDTO toDTO(Mascota mascota) {
		if (mascota == null) {
	        return null;
	    }
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setSexo(mascota.getSexo());
        dto.setEspecie(mascota.getEspecie());
        dto.setTamanio(mascota.getTamanio());
        dto.setEdad(mascota.getEdad());
        dto.setPeso(mascota.getPeso());
        dto.setEsterilizado(mascota.getEsterilizado());
        dto.setVacunado(mascota.getVacunado());
        dto.setDesparasitado(mascota.getDesparasitado());
        dto.setPersonalidad(mascota.getPersonalidad());
        dto.setImagen(mascota.getImagen());
        dto.setCuidadosEspeciales(mascota.getCuidadosEspeciales());
        dto.setHistoria(mascota.getHistoria());
        dto.setDisponibilidad(mascota.getDisponibilidad());
        dto.setRaza(RazaMapper.toDTO(mascota.getRaza(), false));
        
        return dto;
    }
	
	public static Mascota toEntity(MascotaDTO dto) {
		Mascota m = new Mascota();

		m.setId(dto.getId());
		m.setNombre(dto.getNombre());
		m.setSexo(dto.getSexo());
		m.setEspecie(dto.getEspecie());
		m.setTamanio(dto.getTamanio());
		m.setEdad(dto.getEdad());
		m.setPeso(dto.getPeso());
		m.setEsterilizado(dto.getEsterilizado());
		m.setVacunado(dto.getVacunado());
		m.setDesparasitado(dto.getDesparasitado());
		m.setPersonalidad(dto.getPersonalidad());
		m.setImagen(dto.getImagen());
		m.setCuidadosEspeciales(dto.getCuidadosEspeciales());
		m.setHistoria(dto.getHistoria());
		m.setDisponibilidad(dto.getDisponibilidad());

		if (dto.getRaza() != null) {
	        Raza raza = new Raza();
	        raza.setNombre(dto.getRaza().getNombre());
	        m.setRaza(raza);
	    }

		return m;
	}

}
