package com.MCC.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.MCC.demo.models.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
}
