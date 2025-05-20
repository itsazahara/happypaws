package com.daw.services.mappers;

import com.daw.persistence.entities.Cliente;
import com.daw.services.dtos.ClienteDTO;

public class ClienteMapper {

	public static ClienteDTO toDto(Cliente cliente) {
		if (cliente == null) {
			return null;
		}
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

	public static Cliente toEntity(ClienteDTO dto) {
		Cliente c = new Cliente();

		c.setId(dto.getId());
		c.setNombre(dto.getNombre());
		c.setApellidos(dto.getApellidos());
		c.setUsuario(dto.getUsuario());
		c.setTelefono(dto.getTelefono());
		c.setEmail(dto.getEmail());
		c.setDireccion(dto.getDireccion());
		c.setEdad(dto.getEdad());
		c.setOcupacionLaboral(dto.getOcupacionLaboral());
		c.setTipoVivienda(dto.getTipoVivienda());
		c.setOtrasMascotas(dto.getOtrasMascotas());
		c.setObservaciones(dto.getObservaciones());
		c.setImagen(dto.getImagen());

		return c;
	}

	public static void updateEntityFromDto(ClienteDTO dto, Cliente cliente) {
		if (dto == null || cliente == null) {
			return;
		}

		cliente.setNombre(dto.getNombre());
		cliente.setApellidos(dto.getApellidos());
		cliente.setUsuario(dto.getUsuario());
		cliente.setTelefono(dto.getTelefono());
		cliente.setEmail(dto.getEmail());
		cliente.setDireccion(dto.getDireccion());
		cliente.setEdad(dto.getEdad());
		cliente.setOcupacionLaboral(dto.getOcupacionLaboral());
		cliente.setTipoVivienda(dto.getTipoVivienda());
		cliente.setOtrasMascotas(dto.getOtrasMascotas());
		cliente.setExperienciaMascotas(dto.getExperienciaMascotas());
		cliente.setObservaciones(dto.getObservaciones());
		cliente.setImagen(dto.getImagen());
	}

}
