package com.daw.persistence.entities;

import java.time.LocalDateTime;

import com.daw.persistence.entities.enumerados.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_mascota")
    private Integer idMascota;
	
	@ManyToOne
	@JoinColumn(name = "id_mascota", nullable = false, referencedColumnName = "id", insertable = false, updatable = false)
	private Mascota mascota;
	
	@Column(name = "id_cliente")
    private Integer idCliente;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, referencedColumnName = "id", insertable = false, updatable = false)
	private Cliente cliente;
	
	@Column(name = "id_administrador")
    private Integer idAdministrador;

	@ManyToOne
	@JoinColumn(name = "id_administrador", nullable = false, referencedColumnName = "id", insertable = false, updatable = false)
	@JsonIgnore
	private Administrador administrador;

	@Enumerated(EnumType.STRING)
	private Estado estado = Estado.PENDIENTE;

	@Column(nullable = true)
	private String observaciones;

	@Column(name = "fecha_solicitud", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime fechaSolicitud = LocalDateTime.now();
}
