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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "administrador")
public class Administrador {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 200)
    private String apellidos;
    
    @Column(nullable = false, length = 100)
    private String usuario;
    
    @Column(nullable = false, length = 100)
    private String contrasenia;
    
    @Column(nullable = false, length = 100)
    private String email;
    
    @Column(nullable = false, length = 9)
    private String telefono;
    
    @Column(nullable = false)
    private String imagen;

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;
}