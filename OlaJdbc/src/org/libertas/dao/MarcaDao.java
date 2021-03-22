package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.exerciciorelacionamento.Marca;

public class MarcaDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Marca> listar() {
		Query query = em.createQuery("SELECT p FROM Marca p");
		List<Marca> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Marca p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Marca p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Marca p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Marca consultar(int id) {
		Marca p = em.find(Marca.class, id);
		return p;
	}
	
}
