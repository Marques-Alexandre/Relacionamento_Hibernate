package org.libertas.modelteste;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Biblioteca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbiblioteca;
	
	private String nome;
	private String endereco;
	
	@OneToMany
	@JoinColumn(name="idbibliotecafk")
	private List<Livro> livros;

	public int getIdbiblioteca() {
		return idbiblioteca;
	}

	public void setIdbiblioteca(int idbiblioteca) {
		this.idbiblioteca = idbiblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	
}
