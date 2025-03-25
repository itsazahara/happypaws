package com.daw.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cita_servicio")
@Getter
@Setter
@NoArgsConstructor
public class CitaServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_cita", insertable = false, updatable = false)
	private Integer idCita;

	@Column(name = "id_servicio", insertable = false, updatable = false)
	private Integer idServicio;

	@ManyToOne
	@JoinColumn(name = "id_cita")
	private Cita cita;

	@ManyToOne
	@JoinColumn(name = "id_servicio")
	private Servicio servicio;
}
