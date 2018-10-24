package UIBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import EJBDAO.AuctionDAO;
import entities.Auction;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class Home {
	@EJB
	AuctionDAO auction;
	
	public List<Auction> auctions; 
	
	public List<Auction> getAuctions() {
		auctions = auction.getAllAuctions();
		return auctions;
	}
}
