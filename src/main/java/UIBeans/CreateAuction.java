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
import javax.servlet.http.HttpSession;

import ejb.Authenticate;
import ejb.HandleAuctions;
import entities.Auction;
import entities.Product;
import entities.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class CreateAuction {
	
	private String prodName;
	private String prodDescription;
	private String prodCategory;
	private String minBid;
	
	double minimumBid = 0.00;
	
	public String submit() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		FacesContext context = FacesContext.getCurrentInstance();
		User user = (User) session.getAttribute("currentuser");
		
		if(user == null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed: You have to be logged in to create auction", null));
			return "notloggedin";
		}
		Product prod = new Product(prodDescription, prodCategory, prodName);
		Auction newAuction = new Auction();
		newAuction.setProduct(prod);
		newAuction.setUser(user);
		
		try{
			minimumBid = Double.parseDouble(minBid);
		} catch(NumberFormatException ex){
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed: Auction not registerd", null));
			return null;
			
		}
		
		HandleAuctions handel = new HandleAuctions();
		handel.newAuction(newAuction, minimumBid, prod);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Status: Your auction " + prodName + " was successful registered", null));
		return "createdauction";
		
	}
	public String getMinBid() {
		return minBid;
	}
	public void setMinBid(String minBid) {
		this.minBid = minBid;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	
}
