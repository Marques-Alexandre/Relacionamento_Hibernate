package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.exerciciorelacionamento.Cidade;

public class CidadeDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Cidade> listar() {
		Query query = em.createQuery("SELECT p FROM Cidade p");
		List<Cidade> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Cidade p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Cidade p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Cidade p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Cidade consultar(int id) {
		Cidade p = em.find(Cidade.class, id);
		return p;
	}
	
}
