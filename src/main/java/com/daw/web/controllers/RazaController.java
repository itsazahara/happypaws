package com.daw.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daw.persistence.entities.Raza;
import com.daw.services.RazaService;
import com.daw.services.dtos.RazaDTO;
import com.daw.services.mappers.RazaMapper;

@RestController
@RequestMapping("/razas")
public class RazaController {

	@Autowired
	private RazaService razaService;

	@GetMapping
	public ResponseEntity<List<RazaDTO>> razas(){
		List<Raza> razas = this.razaService.findAll();
		List<RazaDTO> razasDTO = new ArrayList<>();
		for(Raza raza : razas) {
			razasDTO.add(RazaMapper.toDTO(raza, false));
		}
		return ResponseEntity.ok(razasDTO);
	}

	@GetMapping("/{idRaza}")
	public ResponseEntity<RazaDTO> raza(@PathVariable int idRaza) {
		Optional<Raza> raza = this.razaService.findById(idRaza);
		if(raza.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(RazaMapper.toDTO(raza.get(), false));
	}

	@PostMapping
    public ResponseEntity<RazaDTO> create(@RequestBody Raza raza) {
		Raza savedRaza = razaService.create(raza);
		RazaDTO razaDTO = RazaMapper.toDTO(savedRaza, false);
        return new ResponseEntity<>(razaDTO, HttpStatus.CREATED);
    }

	@PutMapping("/{idRaza}")
    public ResponseEntity<RazaDTO> update(@PathVariable int idRaza, @RequestBody RazaDTO razaDTO) {
        if (idRaza != razaDTO.getId()) {
            return ResponseEntity.badRequest().build();
        }
        if (!razaService.existsRaza(idRaza)) {
            return ResponseEntity.notFound().build();
        }

        Raza raza = RazaMapper.toEntity(razaDTO);
        Raza updatedRaza = razaService.save(raza);
        RazaDTO responseDTO = RazaMapper.toDTO(updatedRaza, false);

        return ResponseEntity.ok(responseDTO);
    }
	
	@DeleteMapping("/{idRaza}")
    public ResponseEntity<RazaDTO> delete(@PathVariable int idRaza) {
		RazaDTO razaEliminado = razaService.delete(idRaza);
        
        if (razaEliminado != null) {
            return ResponseEntity.ok(razaEliminado);
        }
        
        return ResponseEntity.notFound().build();
    }

	@GetMapping("/buscador")
	public ResponseEntity<List<Raza>> findByNombre(@RequestParam String nombre) {
		return ResponseEntity.ok(this.razaService.getByNombre(nombre));
	}

}
