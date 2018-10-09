package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;

	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private Integer phone;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany
	@JoinColumn(name="feedback_id")
	private List<Feedback> feedback;
	
	@OneToMany
	@JoinColumn(name="auction_id")
	private List<Auction> auction;
	
	public User() {
		
	}
	
	public User(String username, String firstname, String lastname, String email, Integer phone) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		//this.address = address;
		this.email = email;
		this.phone = phone;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
/*
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	
}
