package com.daw.persistence.entities;

import java.util.List;

import com.daw.persistence.entities.enumerados.TipoVivienda;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(nullable = false, length = 100)
    private String nombre;
    
	@Column(nullable = false, length = 200)
    private String apellidos;
    
	@Column(nullable = false, length = 100)
    private String usuario;
    
	@Column(nullable = true, length = 100)
    private String contrasenia;
    
	@Column(nullable = false, length = 100)
    private String email;
    
	@Column(nullable = false, length = 250)
    private String direccion;
    
	@Column(nullable = false, length = 4)
    private Integer edad;
    
	@Column(nullable = false, length = 9)
    private String telefono;
    
	@Column(nullable = false)
    private String ocupacionLaboral;
    
    @Enumerated(EnumType.STRING)
    private TipoVivienda tipoVivienda;
    
    private Boolean otrasMascotas;
    
    private Boolean experienciaMascotas;
    
    @Column(nullable = false)
    private String observaciones;
    
    @Column(nullable = false)
    private String imagen;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reserva> reservas;

}
