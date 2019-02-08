package com.projeto.bar.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.bar.domain.Mesa;
import com.projeto.bar.repositories.MesaRepository;
import com.projeto.bar.services.exceptions.ObjectNotFoundException;

@Service
public class MesaService {

	@Autowired
	private MesaRepository repo;

	public Mesa buscar(Integer id) {

		Optional<Mesa> obj = repo.findById(id);
		return obj.orElse(null);

	}

	public Mesa find(Integer id) {
		Optional<Mesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Mesa.class.getName()));
	}

}
