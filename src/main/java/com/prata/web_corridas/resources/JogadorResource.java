package com.prata.web_corridas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prata.web_corridas.entities.Jogador;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	@GetMapping
	public ResponseEntity<Jogador> findAll(){
		Jogador j = new Jogador(1L, "jose santos", "senha1");  // Só para test se o REST está funcionando. Imprimirá em localhost:8080/jogadores
		return ResponseEntity.ok().body(j);
		
	}

}
