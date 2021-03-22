package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.modelteste.Biblioteca;

public class BibliotecaDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Biblioteca> listar() {
		Query query = em.createQuery("SELECT p FROM Biblioteca p");
		List<Biblioteca> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Biblioteca p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Biblioteca p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Biblioteca p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Biblioteca consultar(int id) {
		Biblioteca p = em.find(Biblioteca.class, id);
		return p;
	}
	
}
