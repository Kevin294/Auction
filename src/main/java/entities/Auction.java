package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "auction")
public class Auction {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "highestBid")
	private Bid highestBid;

	@OneToOne
	@JoinColumn(name = "product")
	private Product product;

	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	@OneToMany
	@JoinColumn(name="id")
	private List<Bid> bids;
	
	public Auction() {
	}

	public Auction(Bid highestBid, Product product, User user) {
		this.highestBid = highestBid;
		this.product = product;
		this.user = user;


	}

}
