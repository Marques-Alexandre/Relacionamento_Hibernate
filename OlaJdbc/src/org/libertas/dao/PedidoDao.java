package org.libertas.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.exerciciorelacionamento.Pedido;

public class PedidoDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
	private static EntityManager em = emf.createEntityManager();
	
	public List<Pedido> listar() {
		Query query = em.createQuery("SELECT p FROM Pedido p");
		List<Pedido> lista = query.getResultList();
		
		return lista;
	}
	
	public void inserir(Pedido p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	
	public void alterar(Pedido p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
	public void excluir(Pedido p) {
		em.getTransaction().begin();
		em.remove(em.merge(p));
		em.getTransaction().commit();
	}
	
	public Pedido consultar(int id) {
		Pedido p = em.find(Pedido.class, id);
		return p;
	}
	
}
