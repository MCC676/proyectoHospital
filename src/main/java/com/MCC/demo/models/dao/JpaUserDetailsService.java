package com.MCC.demo.models.dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MCC.demo.models.entity.Role;
import com.MCC.demo.models.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByUsername(username);
		
		if(username ==null) {
			throw new UsernameNotFoundException("Usuario no existe");
		}
		
		List<GrantedAuthority> listaRoles = new ArrayList<GrantedAuthority>();
		for(Role rol: usuario.getRoles()) {
			listaRoles.add(new SimpleGrantedAuthority(rol.getAuthtority()));
		}
		
		if(listaRoles.isEmpty()) {
			throw new UsernameNotFoundException("El usuario no tiene roles asignados");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEstado(), 
				true, true, true, listaRoles);
	}
	
}
