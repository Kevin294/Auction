package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "bid", schema = "public")
public class Bid implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bidId")
	private Integer id;

	@Column(name = "value")
	private double value;

	@Column(name = "username")
	private String username;
/*
	@ManyToOne
	@JoinColumn(name = "id")
	private Auction auction;
	public Bid() {

	}
*/
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
