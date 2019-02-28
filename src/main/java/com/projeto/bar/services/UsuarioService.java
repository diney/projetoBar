package com.projeto.bar.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.bar.domain.Usuario;
import com.projeto.bar.repositories.UsuarioRepository;
import com.projeto.bar.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository repo;;

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setSenha(pe.encode(obj.getSenha()));
		obj = repo.save(obj);

		return obj;
	}
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}


}
