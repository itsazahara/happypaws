package com.daw.services.mappers;

import com.daw.persistence.entities.Administrador;
import com.daw.services.dtos.AdministradorDTO;

public class AdministradorMapper {
	
	public static AdministradorDTO toDto(Administrador administrador) {
		if (administrador == null) {
	        return null;
	    }
		AdministradorDTO dto = new AdministradorDTO();
		dto.setId(administrador.getId());
		dto.setNombre(administrador.getNombre());
		dto.setApellidos(administrador.getApellidos());
		dto.setUsuario(administrador.getUsuario());
		dto.setTelefono(administrador.getTelefono());
		dto.setEmail(administrador.getEmail());
		dto.setImagen(administrador.getImagen());

		return dto;

	}
	
	public static Administrador toEntity(AdministradorDTO dto) {
		Administrador admin = new Administrador();

		admin.setId(dto.getId());
		admin.setNombre(dto.getNombre());
		admin.setApellidos(dto.getApellidos());
		admin.setUsuario(dto.getUsuario());
		admin.setTelefono(dto.getTelefono());
		admin.setEmail(dto.getTelefono());
		admin.setImagen(dto.getImagen());

		return admin;
	}

}
