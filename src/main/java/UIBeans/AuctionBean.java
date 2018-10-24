package UIBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import EJBDAO.AuctionDAO;
import ejb.HandleAuctions;
import entities.Auction;
import entities.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AuctionBean {
	@EJB
	AuctionDAO auction;
	@EJB
	HandleAuctions ha;
	String username;
	Auction selectedauction;
	double bidvalue;
	public List<Auction> auctions;

	public List<Auction> getAuctions() {
		auctions = auction.getAllActiveAuctions();
		return auctions;
	}

	public String submit() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		FacesContext context = FacesContext.getCurrentInstance();
		User user = (User) session.getAttribute("currentuser");
		if (user != null) {
			if (bidvalue > selectedauction.getBid().getValue()) {
				selectedauction.getBid().setValue(bidvalue);
				selectedauction.getBid().setOwner(user.getUsername());
				auction.updateAuction(selectedauction);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Status: Your bid on " + bidvalue + " was successful", null));
				return null;
			}
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Failed", null));
			return null;
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Failed: Not logged in", null));
		return "notloggedin";
	}

	public String endauction() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentuser");
		if (user != null) {
			if (user.getUsername().equals(selectedauction.getUser().getUsername())) {
				User winner = ha.endAuction(selectedauction);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Success. Winner: "+winner.getUsername(), null));
				return null;
			}
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Failed", null));
			return null;
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Not logged in", null));
		return "notloggedin";
	}

	public Auction getSelectedauction() {
		return selectedauction;
	}

	public void setSelectedauction(Auction selectedauction) {
		this.selectedauction = selectedauction;
	}

	public double getBidvalue() {
		return bidvalue;
	}

	public void setBidvalue(double bidvalue) {
		this.bidvalue = bidvalue;
	}

	public String getUsername() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentuser");
		if (user != null) {
			username = user.getUsername();
		} else {
			username = "";
		}
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
