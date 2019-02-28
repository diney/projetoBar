package com.projeto.bar.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.bar.domain.Mesa;
import com.projeto.bar.services.MesaService;

@RestController
@RequestMapping(value = "/mesas")
public class MesaResource {

	@Autowired
	private MesaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mesa> find(@PathVariable Integer id) {
		Mesa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Mesa mesa, @PathVariable Integer id) {
		mesa.setId(id);
		mesa = service.update(mesa);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Mesa>> findAll() {
		List<Mesa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/numero/{numero}", method = RequestMethod.GET)
	public ResponseEntity<Mesa> findByNumero( @PathVariable Integer numero) {
		Mesa obj = service.findByNumero(numero);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Mesa obj) {		
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*@RequestMapping(value = "/mesa/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> findByMesa(@PathVariable Integer id) {
		
		List<Pedido> list = service.findByMesa(id);
		return ResponseEntity.ok().body(list);
	}
*/
}
