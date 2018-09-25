package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "auction")
public class Auction {

	private Bid[] bids;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "highestBid")
	private Bid highestBid;

	@Column(name = "product")
	private Product product;

	@Column(name = "uname")
	private String uname;

	public Auction() {
	}

	public Auction(Integer id, Bid highestBid, Product product, String uname) {
		this.id = id;
		this.highestBid = highestBid;
		this.product = product;
		this.uname = uname;
	}

}
