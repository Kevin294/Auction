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
	
	public Feedback() {
		
	}
	
	public Feedback(Double stars, String username, String message) {
		this.stars = stars;
		this.username = username;
		this.message = message;
	}
}
