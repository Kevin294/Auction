package entities;

import javax.persistence.*;

@Entity
@Table(name = "bid")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "value")
	private double value;

	@Column(name = "username")
	private String username;

	@ManyToOne
	@JoinColumn(name = "id")
	private Auction auction;
	public Bid() {

	}

	public Bid(double value, String username) {
		this.value = value;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
