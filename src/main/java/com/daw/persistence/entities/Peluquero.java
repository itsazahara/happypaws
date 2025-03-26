package com.daw.persistence.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "peluquero")
@Getter
@Setter
@NoArgsConstructor
public class Peluquero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 9)
    private String telefono;
    
    @Column(nullable = false, length = 100)
    private String diaLaboral; // Ejemplo: "Lunes a Viernes"
    
    @Column(nullable = false, length = 100)
    private String horarioInicio; // Ejemplo: "09:00"
    
    @Column(nullable = false, length = 100)
    private String horarioFin; // Ejemplo: "14:00"

    @OneToMany(mappedBy = "peluquero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

}