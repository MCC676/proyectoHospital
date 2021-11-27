package com.MCC.demo.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MCC.demo.models.entity.Atencion;
import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Medicamentos;

@Repository
public class CitaDAOImpl implements ICitasDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private IMedicamentoB medicinaDao;
	
	@Autowired
	private IAtencionDAO atencionDAO;
	
	@Override
	public Citas buscarCita(Long id) {
		return em.find(Citas.class, id);
	}

	@Override
	public Medicamentos findCitaById(Long id) {
		return medicinaDao.findById(id).orElse(null);
	}

	@Override
	public void saveAtencion(Atencion atencion) {
		atencionDAO.save(atencion);
	}

	

}
