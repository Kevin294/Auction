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
	
	private User user;
}
