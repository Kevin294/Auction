package entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "categori")
	private String categori;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	public Product() {

	}

	public Product(String description, String categori, String name) {
		this.description = description;
		this.categori = categori;
		this.name = name;
	}

}
