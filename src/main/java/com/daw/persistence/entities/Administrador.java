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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "administrador")
@AllArgsConstructor
@Builder
public class Administrador implements UserDetails{
	
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
    
    @Column(nullable = false, length = 9)
    private String telefono;
    
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String imagen;
    
    @Enumerated(EnumType.STRING)
	private Rol rol;

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + rol.name()));
	}

    @Override
	public String getPassword() {
		return contrasenia;
	}

    @Override
	public String getUsername() {
		return email;
	}
    
    @Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}