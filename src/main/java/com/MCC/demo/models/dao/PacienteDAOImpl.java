package com.MCC.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.MCC.demo.models.entity.Paciente;


@Repository
public class PacienteDAOImpl implements IPacienteDAO{

	@PersistenceContext
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> getPacientes() {
		return em.createQuery("from Paciente").getResultList();
	}

	@Override
	@Transactional
	public void save(Paciente paciente) {
		if(paciente.getId()!=null && paciente.getId()>0) {
			em.merge(paciente);
		}else {
			em.persist(paciente);
		}
	}

	@Override
	public Paciente buscarPaciente(Long id) {
		return em.find(Paciente.class, id);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Paciente paciente= buscarPaciente(id);
		em.remove(paciente);	
	}

}
