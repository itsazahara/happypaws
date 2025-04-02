package com.daw.services.mappers;

import com.daw.persistence.entities.Cliente;
import com.daw.services.dtos.ClienteDTO;

public class ClienteMapper {
	
	public static ClienteDTO toDto(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO();

		dto.setId(cliente.getId());
		dto.setNombre(cliente.getNombre());
		dto.setApellidos(cliente.getApellidos());
		dto.setUsuario(cliente.getUsuario());
		dto.setTelefono(cliente.getTelefono());
		dto.setEmail(cliente.getEmail());
		dto.setDireccion(cliente.getDireccion());
		dto.setEdad(cliente.getEdad());
		dto.setOcupacionLaboral(cliente.getOcupacionLaboral());
		dto.setTipoVivienda(cliente.getTipoVivienda());
		dto.setOtrasMascotas(cliente.getOtrasMascotas());
		dto.setExperienciaMascotas(cliente.getExperienciaMascotas());
		dto.setObservaciones(cliente.getObservaciones());
		dto.setImagen(cliente.getImagen());
		
		return dto;

	}


}
