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

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.services.MascotaService;
import com.daw.services.dtos.MascotaDTO;
import com.daw.services.dtos.MascotaRequestDTO;
import com.daw.services.mappers.MascotaMapper;
import com.daw.services.mappers.MascotaRequestMapper;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

	@Autowired
	private MascotaService mascotaService;

	@GetMapping
	public ResponseEntity<List<MascotaDTO>> mascotas(){
		List<Mascota> mascotas = this.mascotaService.findAll();
		List<MascotaDTO> mascotasDTO = new ArrayList<>();
		for(Mascota mascota : mascotas) {
			mascotasDTO.add(MascotaMapper.toDTO(mascota));
		}
		return ResponseEntity.ok(mascotasDTO);
	}

	@GetMapping("/{idMascota}")
	public ResponseEntity<MascotaDTO> mascota(@PathVariable int idMascota) {
		Optional<Mascota> mascota = this.mascotaService.findById(idMascota);
		if(mascota.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(MascotaMapper.toDTO(mascota.get()));
	}

	@PostMapping
	public ResponseEntity<Mascota> create(@RequestBody MascotaRequestDTO mascotaRequestDTO) {
		try {
			Mascota nuevaMascota = mascotaService.create(mascotaRequestDTO);

			return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{idMascota}")
    public ResponseEntity<Mascota> update(@PathVariable Integer idMascota, @RequestBody MascotaRequestDTO mascotaRequestDTO) {
        if (!idMascota.equals(mascotaRequestDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Mascota> mascotaOptional = mascotaService.findById(idMascota);
        
        if (!mascotaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        try {
            Mascota mascota = MascotaRequestMapper.toEntity(mascotaRequestDTO);
            mascota.setId(idMascota);
            Mascota updatedMascota = mascotaService.save(mascota);
            return ResponseEntity.ok(updatedMascota);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@DeleteMapping("/{idMascota}")
    public ResponseEntity<MascotaDTO> delete(@PathVariable int idMascota) {
		MascotaDTO mascotaEliminado = mascotaService.delete(idMascota);
        
        if (mascotaEliminado != null) {
            return ResponseEntity.ok(mascotaEliminado);
        }
        
        return ResponseEntity.notFound().build();
    }

	@GetMapping("/buscarPorSexo")
    public List<MascotaDTO> buscarPorSexo(@RequestParam Sexo sexo) {
        return mascotaService.buscarPorSexo(sexo);
    }

	@GetMapping("/buscarPorEspecie")
	public List<MascotaDTO> buscarPorEspecie(@RequestParam Especie especie) {
		return mascotaService.buscarPorEspecie(especie);
	}

	@GetMapping("/esterilizado/{estado}")
	public List<MascotaDTO> getMascotasPorEsterilizado(@PathVariable Boolean estado) {
		return mascotaService.buscarPorEsterilizado(estado);
	}

	@GetMapping("/vacunado/{estado}")
	public List<MascotaDTO> getMascotasPorVacunado(@PathVariable Boolean estado) {
		return mascotaService.buscarPorVacunado(estado);
	}

	@GetMapping("/desparasitado/{estado}")
	public List<MascotaDTO> getMascotasPorDesparasitado(@PathVariable Boolean estado) {
		return mascotaService.buscarPorDesparasitado(estado);
	}

	/* FALTA LA COMPROBAR ESTE ENDPOINT */
	@PutMapping("/{id}/esterilizado")
	public Mascota actualizarEsterilizado(@PathVariable Integer id, @RequestParam Boolean esterilizado) {
		return mascotaService.actualizarEsterilizado(id, esterilizado);
	}

	/* FALTA LA COMPROBAR ESTE ENDPOINT */
	@PutMapping("/{id}/vacunado")
	public Mascota actualizarVacunacion(@PathVariable Integer id, @RequestParam Boolean vacunado) {
		return mascotaService.actualizarVacunacion(id, vacunado);
	}

	/* FALTA LA COMPROBAR ESTE ENDPOINT */
	@PutMapping("/{id}/desparasitado")
	public Mascota actualizarDesparasitado(@PathVariable Integer id, @RequestParam Boolean desparasitado) {
		return mascotaService.actualizarDesparasitado(id, desparasitado);
	}

}
