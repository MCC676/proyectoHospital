package com.MCC.demo.models.dao;

import java.util.List;

import com.MCC.demo.models.entity.Medicamentos;


public interface IMedicamentoDAO {
	public List<Medicamentos> getMedicamento();
	
	public void save(Medicamentos medicamento);
	
	public Medicamentos buscarMedicamento(Long id);
	
	public void eliminar(Long id);
}
