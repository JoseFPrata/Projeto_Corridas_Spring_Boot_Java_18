package com.prata.web_corridas.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   // dizendo que autoincrementavel no banco de dados
	private Long id;
	private String marca;
	private String descricao;
	private String ano;
	
	
	/* aqui está sendo feito o relacionamento entre jogador e Carro, colucando-se @ManyToOne porque jogador terá muitos carros,
	 * mas 1 carro só pertencerá a 1 jogador. Isso possilitará saber quem é o jogador dono de cada carro.
	 * 
	 */
	
	@JsonIgnore     //Colocando o @JsonIgnore aqui o jackson não dará erro e apresentará jogadores e respectivos carros.
	                // Se quisesse apresentar o jogador e seu carro o @JsonIgnore deveria ficar do lado do jogador
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Jogador usuario;    //este nome usuario será usado na classe Jogador para ligar o relacionamento lá de 1 para Muitos @OneToMany
	
	
	public Carro() {
		
		
	}


	public Carro(Long id, String marca, String descricao, String ano, Jogador usuario) {
		super();
		this.id = id;
		this.marca = marca;
		this.descricao = descricao;
		this.ano = ano;
		this.usuario = usuario;
	}


	public Jogador getUsuario() {
		return usuario;
	}


	public void setUsuario(Jogador usuario) {
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
