package com.prata.web_corridas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prata.web_corridas.entities.Carro;
import com.prata.web_corridas.services.CarroService;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {
	
	/* Aqui foi feito só para teste do H@  @GetMapping     
	public ResponseEntity<Carro> findAll(){
		Carro j = new Carro(1L, "jose santos", "senha1");  // Só para test se o REST está funcionando. Imprimirá em localhost:8080/jogadores
		return ResponseEntity.ok().body(j);  
		
	} */
	@Autowired    
	private CarroService service;  // dependência do service. Porém preciso registra-la no CarroService para que o Spring reconheça essa dependência
	
	
	@GetMapping
	public ResponseEntity<List<Carro>> findAll(){
		List<Carro> list = service.findAll();
		return ResponseEntity.ok().body(list);  
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Carro> findById(@PathVariable Long id){
		Carro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);  
		
	}
	
	
	

}
