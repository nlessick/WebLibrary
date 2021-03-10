package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.BookDetails;

/**
 * @author {Nathaniel Essick} - nlessick
 * CIS175 - Spring 2021
 * {3/10/2021}
 */
public class BookDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleWebLibrary");
	
	public void insertNewBookDetails(BookDetails b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BookDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<BookDetails> allDetails = em.createQuery("SELECT d FROM BookDetails d").getResultList();
		return allDetails;
	}

}
