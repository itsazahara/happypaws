package com.daw.persistence.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.daw.persistence.entities.enumerados.Rol;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements UserDetails {

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

	@Enumerated(EnumType.STRING)
	private Rol rol;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Reserva> reservas;

	// Método de ayuda para la gestión de roles
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + rol.name()));
	}

	// Método que devuelve la contraseña del usuario. Spring Security la usa
	// internamente para comparar con la contraseña que el usuario ingresó.
	@Override
	public String getPassword() {
		return contrasenia;
	}

	// Método que devuelve el username del usuario. Spring Security lo usa
	// internamente para comparar con el username que el usuario ingresó.
	@Override
	public String getUsername() {
		return email;
	}

	// Método para indicar si la cuenta está o no expirada
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// Método para indicar si la cuenta esta o no bloqueada
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// Método para indicar si las credenciales están o no expiradas
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
