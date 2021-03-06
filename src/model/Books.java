/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Mar 6, 2021
 */
package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Books {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Publish_Date")
	private LocalDate publishDate;
	
	public Books() {
		
	}

	public Books(String title, LocalDate publishDate) {
		super();
		this.title = title;
		this.publishDate = publishDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publishDate
	 */
	public LocalDate getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Books [Id=" + Id + ", title=" + title + ", publishDate=" + publishDate + "]";
	}
	
}
