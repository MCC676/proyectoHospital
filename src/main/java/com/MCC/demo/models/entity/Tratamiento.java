package com.MCC.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tratamiento")
public class Tratamiento implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	private int cantidad;
	
	//relacion tratemiento-medicinas
	@ManyToOne(fetch = FetchType.LAZY)
	private Medicamentos medicamento;
	
	

	
	
	public Medicamentos getMedicamento() {
		return medicamento;
	}




	public void setMedicamento(Medicamentos medicamento) {
		this.medicamento = medicamento;
	}






	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}






	public double calcularImporte() {
		return this.cantidad * medicamento.getPrecio();
	}


	private static final long serialVersionUID = 1L;
	
}
