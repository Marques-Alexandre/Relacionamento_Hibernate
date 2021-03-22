package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.model.Pessoa;

public class PessoaDaoHibernate {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Pessoa> listar() {
		Query query = em.createQuery("SELECT p FROM Pessoa p");
		List<Pessoa> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Pessoa p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Pessoa p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Pessoa p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Pessoa consultar(int id) {
		Pessoa p = em.find(Pessoa.class, id);
		return p;
	}
	
}
