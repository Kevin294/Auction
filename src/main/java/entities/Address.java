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
	

	
	public Address() {
		
	}
	
	public Address(String address, String country, String city, Integer areacode) {
		this.address = address;
		this.country = country;
		this.city = city;
		this.areacode = areacode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getAreacode() {
		return areacode;
	}

	public void setAreacode(Integer areacode) {
		this.areacode = areacode;
	}
	
}
