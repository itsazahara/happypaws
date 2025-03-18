package com.daw.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

	@Column(name = "id_cita")
	private Integer idCita;

	@Column(name = "id_servicio")
	private Integer idServicio;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_cita")
	private Cita cita;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_servicio")
	private Servicio servicio;

}