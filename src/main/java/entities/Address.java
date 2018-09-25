package entities;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Column(name="areacode")
	private Integer areacode;
	
	@OneToOne
	@JoinColumn(name="username")
	private User user;
	
	public Address() {
		
	}
	
	public Address(String address, String country, String city, Integer areacode, User user) {
		this.address = address;
		this.country = country;
		this.city = city;
		this.areacode = areacode;
		this.user = user;
	}
	
}
