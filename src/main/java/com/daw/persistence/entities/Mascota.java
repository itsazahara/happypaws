package com.daw.persistence.entities;

import java.util.List;

import com.daw.persistence.entities.enumerados.Especie;
import com.daw.persistence.entities.enumerados.Sexo;
import com.daw.persistence.entities.enumerados.Tamanio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "mascota")
public class Mascota {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Enumerated(EnumType.STRING)
    private Especie especie;
    
    @Enumerated(EnumType.STRING)
    private Tamanio tamanio;
    
    @Column(nullable = false)
    private Integer edad;
    
    @Column(columnDefinition = "DECIMAL(5,2)")
    private Double peso;
    
    private Boolean esterilizado;
    
    private Boolean vacunado;
    
    private Boolean desparasitado;
    
    @Column(nullable = false)
    private String personalidad;
    
    @Column(nullable = false)
    private String imagen;
    
    @Column(nullable = false)
    private String cuidadosEspeciales;
    
    @Column(nullable = false)
    private String historia;
    
    private Boolean disponibilidad = true;

    @ManyToOne
    @JoinColumn(name = "id_raza", nullable = false)
    @JsonBackReference
    @JsonIgnoreProperties({"mascotas", "id", "especie", "imagen"})
    private Raza raza;


    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<Reserva> reservas;
}
