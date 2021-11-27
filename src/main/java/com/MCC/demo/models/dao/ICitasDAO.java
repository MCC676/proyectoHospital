package com.MCC.demo.models.dao;

import com.MCC.demo.models.entity.Atencion;
import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Medicamentos;

public interface ICitasDAO {
	public Citas buscarCita(Long id);
	
	public Medicamentos findCitaById(Long id);
	
	public void saveAtencion(Atencion atencion);
}
