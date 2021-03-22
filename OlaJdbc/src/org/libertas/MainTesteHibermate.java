package org.libertas;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.libertas.model.Pessoa;

public class MainTesteHibermate {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoHibernate");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT p FROM Pessoa p");
		Collection<Pessoa> lista = (Collection<Pessoa>) query.getResultList();
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa);
		}
		
		
		em.close();
		emf.close();
	}
}
