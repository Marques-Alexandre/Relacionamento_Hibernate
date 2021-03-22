package org.libertas.modelteste;

import java.util.LinkedList;
import java.util.List;

import org.libertas.dao.LivroDao;

public class MainTesteRelacionamento {
	public static void main(String[] args) {
		
		//Livro l1 = new Livro();
		//l1.setAno(1963);
		//l1.setTitulo("O planeta dos macacos");
		//LivroDao ldao = new LivroDao();
		//ldao.inserir(l1);
		
		//Livro l2 = new Livro();
		//l2.setAno(1980);
		//l2.setTitulo("A fundação");
		//ldao.inserir(l2);
		
		Biblioteca b1 = new Biblioteca();
		b1.setNome("Biblioteca Libertas");
		b1.setEndereco("Av. Wenceslau Braz, 1040");
		List<Livro> livros = new LinkedList<Livro>();
		b1.setLivros(livros);
		
		// adiciona livros do banco de dados para biblioteca
		LivroDao ldao = new LivroDao();
		livros.add(ldao.consultar(1));
		livros.add(ldao.consultar(2));
		
		
		
	}

}
