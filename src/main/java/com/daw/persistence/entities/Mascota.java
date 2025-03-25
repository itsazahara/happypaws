package com.daw.persistence.entities;

import java.util.List;

import com.daw.persistence.entities.enumerados.Tamaño;

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

@Entity
@Table(name = "mascota")
@Getter
@Setter
@NoArgsConstructor
public class Mascota {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tamaño tamaño;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

}
