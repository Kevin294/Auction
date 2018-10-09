package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "bid", schema = "public")
public class Bid implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid_id")
	private Integer id;

	@Column(name = "value")
	private double value;

	@Column(name = "owner")
	private String owner;
/*
	@ManyToOne
	@JoinColumn(name = "auction_id")
	private Auction auction;
*/
	public Bid() {
		
	}
	
	public Bid(double value, String owner) {
		this.value = value;
		this.owner = owner;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
