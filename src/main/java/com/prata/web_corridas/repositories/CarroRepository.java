package com.prata.web_corridas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prata.web_corridas.entities.Carro;
import com.prata.web_corridas.entities.Jogador;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
