package com.MCC.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MCC.demo.models.entity.Medicamentos;

public interface IMedicamentoB  extends CrudRepository<Medicamentos, Long>{
	
	@Query("SELECT p FROM Medicamentos p WHERE p.nombre like %?1%")
	public List<Medicamentos> findByNombre(String term);
}
