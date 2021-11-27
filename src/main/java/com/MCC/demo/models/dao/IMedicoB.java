package com.MCC.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MCC.demo.models.entity.Medicos;

public interface IMedicoB extends CrudRepository<Medicos, Long>{
	
	@Query("SELECT p FROM Medicos p WHERE p.especialidad like %?1%")
	public List<Medicos> findByNombre(String term);
}
