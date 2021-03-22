package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.exerciciorelacionamento.Produto;

public class ProdutoDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Produto> listar() {
		Query query = em.createQuery("SELECT p FROM Produto p");
		List<Produto> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Produto p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Produto p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Produto p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Produto consultar(int id) {
		Produto p = em.find(Produto.class, id);
		return p;
	}
	
}
