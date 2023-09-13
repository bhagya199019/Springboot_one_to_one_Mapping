package com.bitlabs.App.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;




@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private Address address;

	public User(Long id, String name, String email, String password, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    // Constructors, getters, setters
}

/* In Spring Data JPA, a one-to-one relationship between two entities is declared using the @OneToOne annotation. It accepts the following parameters:

fetch — Defines a strategy for fetching data from the database. 
By default, it is EAGER indicating that the data must be eagerly fetched. 
We have set it to LAZY to fetch the entities lazily from the database.
cascade — Defines a set of cascadable operations applied to the associated entity.
 CascadeType.ALL means to apply all cascading operations to the related entity. 
 The cascading operations are applied when you delete or update the parent entity.
mappedBy — Defines the entity that owns the relationship, which is the Address entity in our case.
optional — Defines whether the relationship is optional. If set to false, then a non-null relationship must always exist.
In a bidirectional relationship, we have to specify a @OneToOne annotation in both entities. But only one entity is the owner of the association. Usually, the child entity owns the relationship, and the parent entity is the inverse side of the relationship.

@JoinColumn Annotation
The @JoinColumn annotation is used to specify the foreign key column in the relationship owner. The inverse side of the relationship sets the @OneToOne's mappedBy parameter to indicate that the relationship is mapped by the other entity.

The @JoinColumn accepts the following two parameters, among others:

name — Defines the name of the foreign key column.
nullable — Defines whether the foreign key column is nullable. By default, it is true.*/
