package ru.vdcom.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.Column;

@Entity
@Table(name="persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email", nullable=false)
	private String email;
	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy="person")
	private List<Task> tasks;
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Task> getTasks()
	{
		return tasks;
	}
	
	public Person(){
	
	}
	
	public Person(String email) {
		super();
		this.email = email;
	}

	
}
