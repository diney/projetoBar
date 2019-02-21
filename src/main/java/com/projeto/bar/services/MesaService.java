package com.projeto.bar.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.projeto.bar.domain.Mesa;
import com.projeto.bar.domain.Pedido;
import com.projeto.bar.repositories.MesaRepository;
import com.projeto.bar.repositories.PedidoRepository;
import com.projeto.bar.services.exceptions.DataIntegrityException;
import com.projeto.bar.services.exceptions.ObjectNotFoundException;

@Service
public class MesaService {

	@Autowired
	private MesaRepository repo;
	
	

	public Mesa find(Integer id) {
		Optional<Mesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Mesa.class.getName()));
	}

	@Transactional
	public Mesa insert(Mesa obj) {
		obj.setId(null);
		obj = repo.save(obj);

		return obj;
	}

	public Mesa update(Mesa obj) {
		Mesa newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Mesa newObj, Mesa obj) {
		newObj.setNumero(obj.getNumero());

	}

	public List<Mesa> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public Mesa findByNumero(Integer numero) {
		Mesa obj = repo.findByNumero(numero);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Número: " + numero + ", Tipo: " + Mesa.class.getName());
		}
		return obj;
	}

	public Page<Mesa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*public List<Pedido> findByMesa(Integer id){
		List<Pedido> pedidos = pedidoRepository.pedidosByMesa(id);
		return  pedidos;
		
		
	}
	*/
		
		
	
	
	
	

}
