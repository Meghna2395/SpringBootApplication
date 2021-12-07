package com.bridgelabz.springbootexample.model;

import java.util.regex.Matcher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity // The @Entity annotation specifies that the class is an entity and is mapped to
		// a database table.
@Table(name = "Employee") // @Table annotation specifies the name of the database table to be used for
							// mapping.
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue annotation is to configure the way of
														// increment of the specified column(field).

	private long id;

	@Column(name = "firstName")
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,}")
	private String firstName;

	// private String firstName;

	@Column(name = "lastName")
	@Pattern(regexp = "[a-zA-Z]{3,}")
	private String lastName;
	// private String lastName;

	@Column(name = "email", nullable = false) // @Column(nullable = false) annotation only adds a not null constraint to
												// the table definition.
	// private String email;

//	@Pattern(regexp = "[0-9a-zA-Z]+([+._-]{1}[0-9a-zA-Z]+)?@[0-9a-zA-Z]+[.]{1}[a-zA-z]{2,4}([.]{1}[a-zA-z]{2,3})?$\"\r\n"
//			+ "+ \"\";")
	@Pattern(regexp = "[0-9a-zA-Z]+([+._-]{1}[0-9a-zA-Z]+)?@[0-9a-zA-Z]+[.]{1}[a-zA-z]{2,4}([.]{1}[a-zA-z]{2,3})?$"+ "")
	private String email;

	@Column(name = "password")

	@Pattern(regexp = "[A-Za-z0-9@_#$%!]{8,}")
	private String password;
	// private String password;

	public boolean validatePassword(String password) throws Exception {
		if (password == password) {
			return true;
		} else {
			throw new Exception("Invalid password");
		}
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
