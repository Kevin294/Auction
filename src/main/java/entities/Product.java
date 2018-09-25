package entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "categori")
	private String categori;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	

}
