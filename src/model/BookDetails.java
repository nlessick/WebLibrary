package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author {Nathaniel Essick} - nlessick
 * CIS175 - Spring 2021
 * {3/10/2021}
 */
@Entity
@Table(name="Books_Details")
public class BookDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="ID")
	private Publisher publisher;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable (
			name="BOOKS_ON_LIST",
			joinColumns= { @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
			inverseJoinColumns= { @JoinColumn(name="BOOK_ID", referencedColumnName="ID", unique=true) }
			)
	private List<Books> listOfBooks;
	
	public BookDetails() {
		super();
	}

	public BookDetails(int id, String listName, Publisher publisher, List<Books> listOfBooks) {
		super();
		this.id = id;
		this.listName = listName;
		this.publisher = publisher;
		this.listOfBooks = listOfBooks;
	}

	public BookDetails(String listName, Publisher publisher, List<Books> listOfBooks) {
		super();
		this.listName = listName;
		this.publisher = publisher;
		this.listOfBooks = listOfBooks;
	}

	public BookDetails(String listName, Publisher publisher) {
		super();
		this.listName = listName;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Books> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(List<Books> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", listName=" + listName + ", publisher=" + publisher + ", listOfBooks="
				+ listOfBooks + "]";
	}
	
	
}
