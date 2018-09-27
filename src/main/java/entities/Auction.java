package entities;

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

	public Auction(Product product, User user) {
		this.product = product;
		this.user = user;


	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

}
