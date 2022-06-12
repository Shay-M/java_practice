package io.nice.wealthrating.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RichPerson {
	
	@Id	
	@Column(unique=true)
	private long id;
	
	private String firstName;
	private String lastName;
	private long fortune;
	
	
	public RichPerson() {
	
	}
	
	public RichPerson(long id, String firstName, String lastName, long fortune) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fortune = fortune;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getFortune() {
		return fortune;
	}
	public void setFortune(long fortune) {
		this.fortune = fortune;
	}
}
