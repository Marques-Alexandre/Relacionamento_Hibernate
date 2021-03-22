package org.libertas.exerciciorelacionamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcidade;
	
	private String cidade;
	private String uf;
	public int getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	

}
