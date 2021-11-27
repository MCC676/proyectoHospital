package com.MCC.demo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	
	private String password;
	private Boolean estado;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="usuarios_id")
	private List<Role> roles;
	
	
	
	
	public Usuario() {
		this.roles = new ArrayList<Role>();
	}
	
	public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Boolean getEstado() {
		return estado;
	}




	public void setEstado(Boolean estado) {
		this.estado = estado;
	}




	private static final long serialVersionUID = 1L;

}
