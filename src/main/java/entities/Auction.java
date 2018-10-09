package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import entities.User;
import entities.Product;

@Entity
@XmlRootElement
@Table(name = "auction", schema = "public")
@NamedQuery(name="Auction.findAll", query="SELECT t FROM Auction t")
public class Auction implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auction_id")
	private Integer id;
	
	private String enTing;
	private String etNavn;
	
	public static final String FIND_ALL = "Auction.findAll";
/*
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@OneToOne
	@JoinColumn(name = "username")
	private User user;

*/
	public Auction() {
	}
	
	/*
	 public Auction(User user, Product product){
	 	this.user = user;
	 	this.product = product;
	 }
	 */

	public Auction(String etNavn, String enTing) {
		this.etNavn = etNavn;
		this.enTing = enTing;
		


	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnTing() {
		return enTing;
	}

	public void setEnTing(String enTing) {
		this.enTing = enTing;
	}

	public String getEtNavn() {
		return etNavn;
	}

	public void setEtNavn(String etNavn) {
		this.etNavn = etNavn;
	}
	
/*
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
	*/

/*
	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
*/
}
