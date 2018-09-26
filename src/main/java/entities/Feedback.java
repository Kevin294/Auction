package entities;

import javax.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="stars")
	private Double stars;
	
	@Column(name="user")
	private String username;
	
	@Column(name="message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	public Feedback() {
		
	}
	
	public Feedback(Double stars, String username, String message) {
		this.stars = stars;
		this.username = username;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getStars() {
		return stars;
	}

	public void setStars(Double stars) {
		this.stars = stars;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
