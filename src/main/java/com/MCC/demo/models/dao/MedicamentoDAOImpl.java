package com.MCC.demo.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.MCC.demo.models.entity.Medicamentos;

@Repository
public class MedicamentoDAOImpl implements IMedicamentoDAO{
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicamentos> getMedicamento() {
		return em.createQuery("from Medicamentos").getResultList();
	}

	@Override
	@Transactional
	public void save(Medicamentos medicamento) {
		if(medicamento.getId()!=null && medicamento.getId()>0) {
			em.merge(medicamento);
		}else {
			em.persist(medicamento);
		}
	}

	@Override
	public Medicamentos buscarMedicamento(Long id) {
		return em.find(Medicamentos.class, id);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		Medicamentos medicamentos= buscarMedicamento(id);
		em.remove(medicamentos);
	}

}
