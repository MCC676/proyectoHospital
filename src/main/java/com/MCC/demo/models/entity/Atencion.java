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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="atencion")
public class Atencion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private String presion_arterial;
	private String observacion;
	

	
	//relacion atencion-tratamiento
		@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name = "atencion_id", nullable = false)
	private List<Tratamiento> tratamiento;
	
	
	//relacion atencion-cita
	@ManyToOne(fetch = FetchType.LAZY)
	private Citas cita;
	
	
	
	public Atencion() {
		this.tratamiento = new ArrayList<Tratamiento>();
	}
	
	public List<Tratamiento> getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(List<Tratamiento> tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	public void addTratamiento(Tratamiento tratamient) {
		this.tratamiento.add(tratamient);
	}


	public Citas getCita() {
		return cita;
	}

	public void setCita(Citas cita) {
		this.cita = cita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

	public String getPresion_arterial() {
		return presion_arterial;
	}

	public void setPresion_arterial(String presion_arterial) {
		this.presion_arterial = presion_arterial;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@PrePersist
	public void inicializar () {
		fecha=new Date();
	}
	
	public double getTotal() {
		Double total=0.0;
		for(int i=0; i<tratamiento.size();i++) {
			total+= tratamiento.get(i).calcularImporte();
		}
		return total;
	}
	
	private static final long serialVersionUID = 1L;
	
}
