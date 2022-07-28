package com.prata.web_corridas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.prata.web_corridas.entities.Carro;
import com.prata.web_corridas.entities.Jogador;
import com.prata.web_corridas.repositories.CarroRepository;
import com.prata.web_corridas.repositories.JogadorRepository;

@Configuration
@Profile("test")    // este nome teste é o mesmo criado application.properties

// Esta classe servirá para fazer o database seeding, ou seja popular o banco de dados para teste

public class TesteConfig implements CommandLineRunner{
	
	//Porém preciso salvar os dados no Banco e a classe que faz isso é o JogadorRepository. Então este será o primeiro caso 
	// de Injeção de Dependência. E essa dependência tem que ser fraca. Essa dependencia tem que ser declarada e para o Spring
	// realizar essa dependência basta declara @Autowired acima da declaração de dependência. veja abaixo:
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	

	// Mas como fazer isso. Colocar a interface CommandLineRunner com implements CommandLineRunner na classe acima, importe a biblioteca e
	// passe o mouse sobre implments para que o método abaixo public void run(String... args) seja adicionado
	@Override
	public void run(String... args) throws Exception {
			
		Jogador j1 = new Jogador(null, "Maria Brown", "senha2");
		Jogador j2 = new Jogador(null, "Alex Green", "senha3");
		
		jogadorRepository.saveAll(Arrays.asList(j1,j2));
		
		
		Carro cr1 = new Carro(null,  "ford", "maverick", "ano 78, super gastão e veloz ",j1);
		Carro cr2 = new Carro(null, "Chevrolet", "Opala", "ano 76, super gastão e veloz ",j2);
		
		carroRepository.saveAll(Arrays.asList(cr1,cr2));
		
		
		
	} 
	
	

}
