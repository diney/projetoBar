package com.projeto.bar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.bar.domain.Usuario;
import com.projeto.bar.repositories.UsuarioRepository;
import com.projeto.bar.security.UserSS;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Usuario user = usuarioRepository.findByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException(login);
		}

		return new UserSS(user.getId(), user.getLogin(), user.getSenha(), user.getPerfis());
	}
	
	

}
