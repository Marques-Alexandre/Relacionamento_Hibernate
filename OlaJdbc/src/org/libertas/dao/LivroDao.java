package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.modelteste.Livro;

public class LivroDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Livro> listar() {
		Query query = em.createQuery("SELECT p FROM Livro p");
		List<Livro> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Livro p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Livro p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Livro p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Livro consultar(int id) {
		Livro p = em.find(Livro.class, id);
		return p;
	}
	
}
