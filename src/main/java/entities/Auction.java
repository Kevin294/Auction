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

	@Column(name = "highestBid")
	private Bid highestBid;

	@Column(name = "product")
	private Product product;

	@OneToOne
	@JoinColumn(name = "username")
	private User uname;

	@OneToMany
	@JoinColumn(name="id")
	private List<Bid> bids;
	
	public Auction() {
	}

	public Auction(Bid highestBid, Product product, String uname) {
		this.highestBid = highestBid;
		this.product = product;
		this.uname = uname;
	}

}
