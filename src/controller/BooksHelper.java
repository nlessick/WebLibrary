/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Mar 6, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Books;

public class BooksHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleWebLibrary");

	public BooksHelper() {
		
	}
	
	/**
	 * Adds Book.
	 * @param x book to add
	 */
	public void insertBook(Books x) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(x);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Searches for book by title.
	 * @param title of book
	 * @return
	 */
	public List<Books> searchByTitle(String title) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Books> typedQuery = em.createQuery("SELECT i FROM Books i WHERE i.title = :selectedName", Books.class);
		typedQuery.setParameter("selectedName", title);
		
		List<Books> locatedBook = typedQuery.getResultList();
		em.close();
		return locatedBook;
		
	}
	 /**
	  * Searches for book by Id.
	  * @param bookId Id of book
	  * @return book
	  */
	public Books searchById(int bookId) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Books located = em.find(Books.class, bookId);
		em.close();
		return located;
		
	}
	
	/**
	 * Updates book.
	 * @param bookToEdit book to update
	 */
	public void updateBook(Books bookToEdit) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(bookToEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * Deletes book.
	 * @param x book to delete
	 */
	public void deleteBook(Books x) {

		// Find book
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Books> typedQuery = em.createQuery("SELECT i FROM Books i WHERE i.title = :selectedTitle and i.publishDate = :selectedDate", Books.class);

		typedQuery.setParameter("selectedTitle", x.getTitle());
		typedQuery.setParameter("selectedDate", x.getPublishDate());

		typedQuery.setMaxResults(1);

		Books result = typedQuery.getSingleResult();

		// Delete book
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	
	/**
	 * Retrieves all books.
	 * @return all books
	 */
	public List<Books> retrieveAllBooks() {
		
		EntityManager em = emfactory.createEntityManager();
		List<Books> allBooks = em.createQuery("SELECT i FROM Books i").getResultList();
		return allBooks;
		
	}
	
	/**
	 * Closes emfactory.
	 */
	public void cleanUp() {
		
		emfactory.close();
		
	}

}
