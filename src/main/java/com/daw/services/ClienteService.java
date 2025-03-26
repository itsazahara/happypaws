package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Cliente;
import com.daw.persistence.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public boolean existsCliente(int idCliente){
		return this.clienteRepository.existsById(idCliente);
	}
	
	public Optional<Cliente> findById(int idCliente){
		return this.clienteRepository.findById(idCliente);
	}
	
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public boolean delete(int idCliente) {
		boolean result = false;
		
		if(this.clienteRepository.existsById(idCliente)) {
			this.clienteRepository.deleteById(idCliente);
			result = true;
		}
		
		return result;
	}
	
	public List<Cliente> buscarPorNombre(String nombre) {
        return clienteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Cliente> buscarPorTelefono(String telefono) {
        return clienteRepository.findByTelefono(telefono);
    }

    /*public List<Cita> obtenerHistorialCitas(int idCliente) {
        return CitaRepository.findByClienteId(idCliente);
    }*/

    public Cliente actualizarDatosContacto(int id, Cliente datosActualizados) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        cliente.setNombre(datosActualizados.getNombre());
        cliente.setTelefono(datosActualizados.getTelefono());
        cliente.setEmail(datosActualizados.getEmail());

        return clienteRepository.save(cliente);
    }

}
