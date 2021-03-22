package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.exerciciorelacionamento.Cliente;

public class ClienteDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Cliente> listar() {
		Query query = em.createQuery("SELECT p FROM Cliente p");
		List<Cliente> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Cliente p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Cliente p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Cliente p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Cliente consultar(int id) {
		Cliente p = em.find(Cliente.class, id);
		return p;
	}
	
}
