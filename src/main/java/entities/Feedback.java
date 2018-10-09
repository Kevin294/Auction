package entities;


import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feedback_id")
	private Integer id;
	
	@Column(name="stars")
	private double stars;
	
	@Column(name="navn")
	private String navn;
	
	@Column(name = "message")
	private String message;
	
	/*
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	*/
	
	public Feedback() {
		
	}
	
	public Feedback(double stars, String navn, String message) {
		this.stars = stars;
		this.navn = navn;
		this.message = message;
		
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}
}
