package com.daw.services.mappers;

import com.daw.persistence.entities.Administrador;
import com.daw.persistence.entities.Cliente;
import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.Raza;
import com.daw.persistence.entities.Reserva;
import com.daw.services.dtos.ReservaDTO;

public class ReservaMapper {

    public static ReservaDTO toDTO(Reserva reserva, boolean includeClientes) {
        ReservaDTO dto = new ReservaDTO();

        dto.setId(reserva.getId());
        dto.setMascotas(MascotaMapper.toDTO(reserva.getMascota()));
        dto.setClientes(ClienteMapper.toDto(reserva.getCliente()));
        dto.setAdministradores(AdministradorMapper.toDto(reserva.getAdministrador()));
        dto.setEstado(reserva.getEstado());
        dto.setFechaSolicitud(reserva.getFechaSolicitud());
        dto.setObservaciones(reserva.getObservaciones());
        
        return dto;
    }
    
    public static Reserva toEntity(ReservaDTO dto) {
    	Reserva res = new Reserva();

    	res.setId(dto.getId());
    	res.setEstado(dto.getEstado());
    	res.setFechaSolicitud(dto.getFechaSolicitud());
    	res.setObservaciones(dto.getObservaciones());
    	
    	if (dto.getAdministradores() != null) {
    		Administrador admin = new Administrador();
	        admin.setNombre(dto.getAdministradores().getNombre());
	        res.setAdministrador(admin);
	    }
    	
    	if (dto.getClientes() != null) {
    		Cliente cli = new Cliente();
    		cli.setNombre(dto.getClientes().getNombre());
    		cli.setApellidos(dto.getClientes().getApellidos());
    		cli.setUsuario(dto.getClientes().getUsuario());
    		cli.setTelefono(dto.getClientes().getTelefono());
    		cli.setEmail(dto.getClientes().getEmail());
    		cli.setDireccion(dto.getClientes().getDireccion());
    		cli.setEdad(dto.getClientes().getEdad());
    		cli.setOcupacionLaboral(dto.getClientes().getOcupacionLaboral());
    		cli.setTipoVivienda(dto.getClientes().getTipoVivienda());
    		cli.setOtrasMascotas(dto.getClientes().getOtrasMascotas());
    		cli.setExperienciaMascotas(dto.getClientes().getExperienciaMascotas());
    		cli.setObservaciones(dto.getClientes().getObservaciones());
    		cli.setImagen(dto.getClientes().getImagen());
	        res.setCliente(cli);
	    }
    	
    	if (dto.getMascotas() != null) {
    		Mascota m = new Mascota();
    		m.setNombre(dto.getMascotas().getNombre());
    		m.setSexo(dto.getMascotas().getSexo());
    		m.setEspecie(dto.getMascotas().getEspecie());
    		m.setTamanio(dto.getMascotas().getTamanio());
    		m.setEdad(dto.getMascotas().getEdad());
    		m.setPeso(dto.getMascotas().getPeso());
    		m.setEsterilizado(dto.getMascotas().getEsterilizado());
    		m.setVacunado(dto.getMascotas().getVacunado());
    		m.setDesparasitado(dto.getMascotas().getDesparasitado());
    		m.setPersonalidad(dto.getMascotas().getPersonalidad());
    		m.setImagen(dto.getMascotas().getImagen());
    		m.setCuidadosEspeciales(dto.getMascotas().getCuidadosEspeciales());
    		m.setHistoria(dto.getMascotas().getHistoria());
    		m.setDisponibilidad(dto.getMascotas().getDisponibilidad());

    		if (dto.getMascotas().getRaza() != null) {
    	        Raza raza = new Raza();
    	        raza.setNombre(dto.getMascotas().getRaza().getNombre());
    	        m.setRaza(raza);
    	    }
    		
    		res.setMascota(m);
    	}

		return res;
	}
}
