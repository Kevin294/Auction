package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

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
	
	@Column(name="password")
	private String password;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="votes")
	private Integer votes;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="address_id")
	private Address address;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Feedback> feedback;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Auction> auction;
	
	public User() {
		
	}
	
	public User(String username, String firstname, String lastname, Address address, String email, Integer phone, String password) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.votes = 0;
		this.rating = 0;
		
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
	
	@XmlTransient
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@XmlTransient
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	
	@XmlTransient
	public List<Auction> getAuction() {
		return auction;
	}

	public void setAuction(List<Auction> auction) {
		this.auction = auction;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

}
