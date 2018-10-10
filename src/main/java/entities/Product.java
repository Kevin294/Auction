package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "public")
public class Product implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private String category;

	@Column(name = "name")
	private String name;
/*
	@OneToOne
	@JoinColumn(name = "auction_id")
	private Auction auction;
*/
	public Product() {

	}

	public Product(String description, String categori, String name) {
		this.description = description;
		this.category = categori;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
