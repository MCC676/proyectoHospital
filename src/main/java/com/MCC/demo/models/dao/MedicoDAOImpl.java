package com.MCC.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MCC.demo.models.entity.Citas;
import com.MCC.demo.models.entity.Medicos;

@Repository
public class MedicoDAOImpl implements IMedicoDAO{

	@PersistenceContext
	private EntityManager em;
	
		
	@Autowired
	private ICitaDAO citaDAO;
	
	@Autowired
	private IMedicoB buscarDAO;
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medicos> getMedico() {
		return em.createQuery("from Medicos").getResultList();
	}

	@Override
	@Transactional
	public void save(Medicos medico) {
		if(medico.getId()!=null && medico.getId()>0) {
			em.merge(medico);
		}else {
			em.persist(medico);
		}
	}

	@Override
	public Medicos buscarMedicos(Long id) {
		return em.find(Medicos.class, id);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Medicos medicos= buscarMedicos(id);
		em.remove(medicos);
	}

	@Override
	public void saveCita(Citas cita) {
		citaDAO.save(cita);
	}

}
