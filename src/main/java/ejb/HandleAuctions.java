package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import EJBDAO.AuctionDAO;
import EJBDAO.UserDAO;
import entities.*;

@Stateless
public class HandleAuctions {
	
	@EJB
	AuctionDAO auctiondao;
		
	@EJB
	UserDAO userdao;
	
	public void newAuction(Auction auction, double minimumbid, Product product) {
		Bid bid = new Bid(minimumbid, auction.getUser().getUsername());
		auction.setBid(bid);
		auction.setProduct(product);
		auctiondao.addAuction(auction);
		
	}
	
	public void bid(User user, double bidvalue, Auction auction) {
		Bid bid = new Bid(bidvalue, user.getUsername());
		auction.setBid(bid);
		auctiondao.updateAuction(auction);
	}

	public User endAuction(Auction auction) {
		Auction auc = auctiondao.getAuctionById(auction.getId());
		auc.setActive(false);
		auctiondao.updateAuction(auc);
		return userdao.getUserById(auc.getBid().getOwner());
	}
	
	public List<Auction> getActiveAuctions(){
		return auctiondao.getAllActiveAuctions();
	}
	
	public List<Auction> getAuctionsWon(String username){
		List<Auction> temp = auctiondao.getAllNonActiveAuctions();
		List<Auction> result = new ArrayList<Auction>();
		for(Auction e: temp) {
			if(!e.isActive() && username.equals(e.getBid().getOwner())) {
				result.add(e);
			}
		}
		return result;
	}
}
