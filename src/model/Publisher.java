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
@Table(name="Publishers")
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Name")
	private String name;

	
	public Publisher() {
		super();
	}

	public Publisher(String name) {
		super();
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */

	@Override
	public String toString() {
		return "Publisher [Id=" + Id + ", name=" + name + "]";
	}

}
