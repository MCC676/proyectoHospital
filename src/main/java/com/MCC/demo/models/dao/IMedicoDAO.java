package com.MCC.demo.models.dao;

import java.util.List;

import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Medicos;



public interface IMedicoDAO {
	public List<Medicos> getMedico();
	
	public void save(Medicos medico);
	
	public Medicos buscarMedicos(Long id);
	
	public void eliminar(Long id);
	
	public void saveCita(Citas cita);
	
	
}
