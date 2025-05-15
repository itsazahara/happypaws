package com.daw.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Cliente;
import com.daw.services.ClienteService;
import com.daw.services.dtos.ClienteDTO;
import com.daw.services.mappers.ClienteMapper;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> clientes() {
		List<Cliente> clientes = this.clienteService.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(ClienteMapper.toDto(cliente));
		}
		return ResponseEntity.ok(clientesDTO);
	}

	@GetMapping("/{idCliente}")
	public ResponseEntity<ClienteDTO> cliente(@PathVariable int idCliente) {
		Optional<Cliente> cliente = this.clienteService.findById(idCliente);
		if (cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(ClienteMapper.toDto(cliente.get()));
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@RequestBody Cliente cliente) {
		Cliente savedCliente = clienteService.create(cliente);
		ClienteDTO clienteDTO = ClienteMapper.toDto(savedCliente);
		return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idCliente}")
	public ResponseEntity<ClienteDTO> update(@PathVariable int idCliente, @RequestBody ClienteDTO clienteDTO) {
		if (idCliente != clienteDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!clienteService.existsCliente(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		Cliente cliente = ClienteMapper.toEntity(clienteDTO);
		Cliente updatedCliente = clienteService.save(cliente);
		ClienteDTO responseDTO = ClienteMapper.toDto(updatedCliente);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable int idCliente) {
		ClienteDTO clienteEliminado = clienteService.delete(idCliente);

		if (clienteEliminado != null) {
			return ResponseEntity.ok(clienteEliminado);
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/otras-mascotas")
	public Cliente actualizarOtrasMascotas(@PathVariable Integer id, @RequestParam Boolean otrasMascotas) {
		return clienteService.actualizarOtrasMascotas(id, otrasMascotas);
	}

	@PutMapping("/{id}/experiencia-mascotas")
	public Cliente actualizarExperienciaMascotas(@PathVariable Integer id, @RequestParam Boolean experienciaMascotas) {
		return clienteService.actualizarExperienciaMascotas(id, experienciaMascotas);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Cliente loginRequest) {
	    String email = loginRequest.getEmail();
	    String contrasenia = loginRequest.getContrasenia();
	    String usuario = loginRequest.getUsuario();

	    Optional<Cliente> cliente = Optional.empty();

	    // Intentar encontrar por email si se proporciona
	    if (email != null && !email.isEmpty()) {
	        cliente = clienteService.findByEmail(email);
	    }

	    // Si no se encuentra por email, intentar con el nombre de usuario
	    if ((!cliente.isPresent()) && usuario != null && !usuario.isEmpty()) {
	        cliente = clienteService.findByUsuario(usuario);
	    }

	    if (cliente.isPresent() && cliente.get().getContrasenia().equals(contrasenia)) {
	        return ResponseEntity.ok(ClienteMapper.toDto(cliente.get()));
	    }

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	}
	
	@GetMapping("/holaSeguro")
	public String sayHelloSeguro() {
		return "Estoy diciendo hola seguro";
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<ClienteDTO> getClienteByEmail(@PathVariable String email) {
	    Optional<Cliente> cliente = clienteService.findByEmail(email);
	    if (cliente.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(ClienteMapper.toDto(cliente.get()));
	}


}
