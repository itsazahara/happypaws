package com.daw.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.daw.persistence.entities.Mascota;
import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;

public interface MascotaRepository extends ListCrudRepository<Mascota, Integer> {

	List<Mascota> findBySexo(Sexo sexo);

	List<Mascota> findByEspecie(Especie especie);

	List<Mascota> findByEsterilizado(Boolean esterilizado);

	List<Mascota> findByVacunado(Boolean vacunado);

	List<Mascota> findByDesparasitado(Boolean desparasitado);

	List<Mascota> findByRazaId(int idRaza);

}
