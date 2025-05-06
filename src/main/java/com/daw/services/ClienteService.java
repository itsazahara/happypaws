package com.daw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.persistence.entities.Cliente;
import com.daw.persistence.repositories.ClienteRepository;
import com.daw.services.dtos.ClienteDTO;
import com.daw.services.mappers.ClienteMapper;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	public boolean existsCliente(int idCliente) {
		return this.clienteRepository.existsById(idCliente);
	}

	public Optional<Cliente> findById(int idCliente) {
		return this.clienteRepository.findById(idCliente);
	}

	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public ClienteDTO delete(int idCliente) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);

		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			clienteRepository.delete(cliente);
			return ClienteMapper.toDto(cliente);
		}

		return null;
	}

	@Transactional
	public Cliente actualizarOtrasMascotas(Integer id, Boolean otrasMascotas) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			cliente.setOtrasMascotas(otrasMascotas);
			return clienteRepository.save(cliente);
		} else {
			throw new RuntimeException("Cliente no encontrado con ID: " + id);
		}
	}
	
	@Transactional
	public Cliente actualizarExperienciaMascotas(Integer id, Boolean experienciaMascotas) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteOptional.get();
			cliente.setExperienciaMascotas(experienciaMascotas);
			return clienteRepository.save(cliente);
		} else {
			throw new RuntimeException("Cliente no encontrado con ID: " + id);
		}
	}
	
	public Optional<Cliente> findByEmail(String email) {
	    return clienteRepository.findByEmail(email);
	}
	
	public Optional<Cliente> findByUsuario(String usuario){
		return clienteRepository.findByUsuario(usuario);
	}

}
