package UIBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import EJBDAO.UserDAO;
import ejb.HandleAuctions;
import entities.Auction;
import entities.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class Yourauctions {
	@EJB
	HandleAuctions ha;
	@EJB
	UserDAO userdao;
	User user;
	List<Auction> auctions;
	Auction selectedauction;

	public String submit() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentuser");
		if (user == null) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Failed: Not logged in", null));
			return "notloggedin";
		}
		if (selectedauction.isActive()) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Failed: Auction still active", null));
			return null;
		}
		user = getUser();
		return "viewuser";
	}

	public User getUser() {
		return userdao.getUserById(selectedauction.getBid().getOwner());
	}

	public List<Auction> getAuctions() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentuser");
		if (user == null) {
			return null;
		}
		return ha.getAuctionsByUser(user.getUsername());
	}

	public Auction getSelectedauction() {
		return selectedauction;
	}

	public void setSelectedauction(Auction selectedauction) {
		this.selectedauction = selectedauction;
	}

}
