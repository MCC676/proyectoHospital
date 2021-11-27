package com.MCC.demo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="medicos")
public class Medicos implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	private String nombre;
	private String apellidos;
	
	private String especialidad; 
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIngreso;
	
	
	//relacion paciente-cita
	@OneToMany(mappedBy = "medicos",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Citas> citas;
	
	public Medicos() {
		citas=new ArrayList<>();
	}
	
	
	
	
	public List<Citas> getCitas() {
		return citas;
	}




	public void setCitas(List<Citas> citas) {
		this.citas = citas;
	}




	public void inicializar () {
		fechaIngreso=new Date();
	}
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}




	public String getEspecialidad() {
		return especialidad;
	}




	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}




	public Date getFechaIngreso() {
		return fechaIngreso;
	}




	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}




	private static final long serialVersionUID = 1L;
	
}
