package UIBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import ejb.Authenticate;
import entities.Address;
import entities.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class Register {
	@EJB
	Authenticate auth;

	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private Integer phone;
	private String password;
	private String address;
	private String country;
	private String city;
	private Integer areacode;

	
	public String submit() {
		FacesContext context = FacesContext.getCurrentInstance();
		Address add = new Address(address, country, city, areacode);
		User user = new User(username, firstname, lastname, add, email, phone, password);
		if(auth.register(user))
		{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: true", null));
			return "loggedin";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: false", null));
		return null;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
