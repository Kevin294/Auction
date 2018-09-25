package entities;

import javax.persistence.*;

@Entity
@Table(name="bid")
public class Bid {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name = "value")
	private Double value;
	
	@Column(name ="user")
	private String username;
	
	public Bid() {
		
	}
	
	public Bid(Double value, String username) {
		this.value = value;
		this.username = username;
	}
}
