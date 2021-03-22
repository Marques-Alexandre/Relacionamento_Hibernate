package org.libertas.exerciciorelacionamento;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idendereco;
	
	private String logradouro;
	private int numero;
	private String bairro;
	private String cep;
	
	@OneToMany
	@JoinColumn(name="idenderecofk")
	private List<Cidade> cidades;
	
	
	public int getIdendereco() {
		return idendereco;
	}
	public void setIdendereco(int idendereco) {
		this.idendereco = idendereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	

}
