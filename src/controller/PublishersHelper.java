package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Publisher;

/**
 * @author {Nathaniel Essick} - nlessick
 * CIS175 - Spring 2021
 * {3/9/2021}
 */
public class PublishersHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleWebLibrary");
	
	public void insertPublisher(Publisher p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Publisher> showAllPublishers() {
		EntityManager em = emfactory.createEntityManager();
		List<Publisher> allPublishers = em.createQuery("SELECT p FROM Publisher p").getResultList();
		return allPublishers;
	}
	
	public Publisher findPublisher(String nameToLookUp) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Publisher> typedQuery = em.createQuery("select pb from Publisher pb where pb.name = :selectedName", Publisher.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Publisher foundPublisher;
		try {
			foundPublisher = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundPublisher = new Publisher(nameToLookUp);
		}
		em.close();
		
		return foundPublisher;
	}

}
