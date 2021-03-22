package org.libertas.exerciciorelacionamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtelefone;
	
	private String numero;

	public int getIdtelefone() {
		return idtelefone;
	}

	public void setIdtelefone(int idtelefone) {
		this.idtelefone = idtelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
