package com.prata.web_corridas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prata.web_corridas.entities.Jogador;
import com.prata.web_corridas.services.JogadorService;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	/* Aqui foi feito só para teste do H@  @GetMapping     
	public ResponseEntity<Jogador> findAll(){
		Jogador j = new Jogador(1L, "jose santos", "senha1");  // Só para test se o REST está funcionando. Imprimirá em localhost:8080/jogadores
		return ResponseEntity.ok().body(j);  
		
	} */
	@Autowired    
	private JogadorService service;  // dependência do service. Porém preciso registra-la no JogadorService para que o Spring reconheça essa dependência
	
	@GetMapping
	public ResponseEntity<List<Jogador>> findAll(){
		List<Jogador> list = service.findAll();
		return ResponseEntity.ok().body(list);  
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogador> findById(@PathVariable Long id){
		Jogador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);  
		
	}

}
