package com.daw.persistence.entities;

import java.util.List;

import com.daw.persistence.entities.enumerados.Especie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "raza")
public class Raza {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    private Especie especie;
    
    @Column
    private String imagen;

    @OneToMany(mappedBy = "raza", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"raza"})
    private List<Mascota> mascotas;

}