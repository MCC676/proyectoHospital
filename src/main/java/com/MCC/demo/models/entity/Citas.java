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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cita")
public class Citas implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaCita;
	
	//relacion cita-medico
	@ManyToOne(fetch = FetchType.LAZY)
	private Medicos medicos;
	
	
	//relacion cita-paciente
	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente paciente;
	
	//relacion cita-atenciones
	@OneToMany(mappedBy = "cita",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Atencion> atenciones;
	
	
	public List<Atencion> getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(List<Atencion> atenciones) {
		this.atenciones = atenciones;
	}
	
	public List<Atencion> getAtencion() {
		return atenciones;
	}

	public void setAtencion(List<Atencion> atencion) {
		this.atenciones = atencion;
	}

	public Citas() {
		atenciones=new ArrayList<>();
	}
	
	public Medicos getMedicos() {
		return medicos;
	}

	public void setMedicos(Medicos medicos) {
		this.medicos = medicos;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void inicializar () {
		fechaCita=new Date();
	}
	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Date getFechaCita() {
		return fechaCita;
	}





	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}


	public void addAtencion(Atencion atencion) {
		atenciones.add(atencion);
	}



	private static final long serialVersionUID = 1L;

}
