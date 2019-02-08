package com.projeto.bar.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.bar.domain.Mesa;
import com.projeto.bar.services.MesaService;

@RestController
@RequestMapping(value="/mesas")
public class MesaResource {
	
	@Autowired
	private MesaService service;
	
	@RequestMapping(value ="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Mesa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}


