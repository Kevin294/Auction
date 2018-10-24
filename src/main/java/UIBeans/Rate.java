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
public class Rate {

	@EJB
	HandleAuctions ha;
	@EJB
	UserDAO userdao;
	List<Auction> auctions;
	Auction selectedauction;
	double rating;

	public String submit() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentuser");
		FacesContext context = FacesContext.getCurrentInstance();
		if (user != null) {
			User target = selectedauction.getUser();
			Integer votes = target.getVotes();
			double result = target.getRating()*votes;
			votes++;
			result = result+rating;
			result = result/votes;
			target.setRating(result);
			target.setVotes(votes);;
			userdao.updateUser(target);
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Not logged in", null));
		return "notloggedin";
	}
	
	public List<Auction> getAuctions() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("currentuser");
		if (user != null) {
			return ha.getAuctionsWon(user.getUsername());
		}
		return null;
	}

	public Auction getSelectedauction() {
		return selectedauction;
	}

	public void setSelectedauction(Auction selectedauction) {
		this.selectedauction = selectedauction;
	}
	
}
