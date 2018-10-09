package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "public")
public class Product implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "categori")
	private String categori;

	@Column(name = "name")
	private String name;
/*
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
*/
	public Product() {

	}

	public Product(String description, String categori, String name) {
		this.description = description;
		this.categori = categori;
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

	public String getCategori() {
		return categori;
	}

	public void setCategori(String categori) {
		this.categori = categori;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
*/
}
