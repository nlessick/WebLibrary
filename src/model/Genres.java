/**
 * @author Jaden Schuster - jdschuster
 * CIS175 - Spring 2021
 * Mar 6, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genres")
public class Genres {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int Id;
	
	@Column(name="Type")
	private String type;
	
	public Genres() {
		super();
	}

	public Genres(String type) {
		super();
		this.type = type;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Genres [Id=" + Id + ", type=" + type + "]";
	}

}
