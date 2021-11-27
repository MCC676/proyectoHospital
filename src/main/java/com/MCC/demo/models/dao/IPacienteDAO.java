package com.MCC.demo.models.dao;

import java.util.List;


import com.MCC.demo.models.entity.Paciente;

public interface IPacienteDAO {
	public List<Paciente> getPacientes();
	
	public void save(Paciente paciente);
	
	public Paciente buscarPaciente(Long id);
	
	public void eliminar(Long id);
	
	//public List<Paciente> findByNombre(String term);
}
