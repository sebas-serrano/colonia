package com.colonia.service;

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

import com.colonia.model.Usuario;
import com.colonia.repo.IUsuarioRepo;

@Service 
public class UserService implements UserDetailsService {


	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Creamos un metodo que busque el user de la base de datos por nobre
		Usuario us = repo.findByNombre(username);
		
		//Harcodeamos Roles por que en este sistemas no usamoas roles
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails user = new User(us.getNombre(),us.getPassword(),roles);
		
		return user;
	}
	

}
