package entities;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="areacode")
	private Integer areacode;
	
	
	
}
