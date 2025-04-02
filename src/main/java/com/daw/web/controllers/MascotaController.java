package com.daw.web.controllers;

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

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.services.MascotaService;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

	@Autowired
	private MascotaService mascotaService;

	@GetMapping
	public ResponseEntity<List<Mascota>> list() {
		return ResponseEntity.ok(this.mascotaService.findAll());
	}

	@GetMapping("/{idMascota}")
	public ResponseEntity<Mascota> findById(@PathVariable int idMascota) {
		Optional<Mascota> mascota = this.mascotaService.findById(idMascota);
		if (mascota.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(mascota.get());
	}

	@PostMapping
	public ResponseEntity<Mascota> create(@RequestBody Mascota mascota) {
		return new ResponseEntity<Mascota>(this.mascotaService.create(mascota), HttpStatus.CREATED);
	}

	@PutMapping("/{idMascota}")
	public ResponseEntity<Mascota> update(@PathVariable int idMascota, @RequestBody Mascota mascota) {
		if (idMascota != mascota.getId()) {
			return ResponseEntity.badRequest().build();
		} else if (!this.mascotaService.existsMascota(idMascota)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.mascotaService.save(mascota));
	}

	@DeleteMapping("/{idMascota}")
	public ResponseEntity<Mascota> delete(@PathVariable int idMascota) {
		if (this.mascotaService.delete(idMascota)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/buscarPorSexo")
	public List<Mascota> buscarPorSexo(@RequestParam Sexo sexo) {
		return mascotaService.buscarPorSexo(sexo);
	}

	@GetMapping("/buscarPorEspecie")
	public List<Mascota> buscarPorEspecie(@RequestParam Especie especie) {
		return mascotaService.buscarPorEspecie(especie);
	}

	@GetMapping("/esterilizado/{estado}")
	public List<Mascota> getMascotasPorEsterilizado(@PathVariable Boolean estado) {
		return mascotaService.buscarPorEsterilizado(estado);
	}

	@GetMapping("/vacunado/{estado}")
	public List<Mascota> getMascotasPorVacunado(@PathVariable Boolean estado) {
		return mascotaService.buscarPorVacunado(estado);
	}

	@GetMapping("/desparasitado/{estado}")
	public List<Mascota> getMascotasPorDesparasitado(@PathVariable Boolean estado) {
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
