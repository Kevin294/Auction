package soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import EJBDAO.AuctionDAO;
import EJBDAO.BidDAO;
import entities.Product;
import entities.Address;
import entities.Auction;
import entities.Bid;
import entities.TestEntity;
import entities.User;

@WebService
public class SoapService {
	
	@EJB
	AuctionDAO a;
	
	@EJB
	BidDAO b;
	
	@WebMethod(operationName = "GetAuction")
	public Auction getAuction (int id) {
		
		return a.getAuctionById(id);
	}
	
	@WebMethod(operationName = "GetAllActiveAuctions")
	public List<Auction> getAllActiveAuctions(){
		return a.getAllActiveAuctions();
	}
	
	@WebMethod(operationName = "BidOnActiveAuction")
	public boolean bidOnAuction(double value, int auctionId) {
		Auction temp = a.getAuctionById(auctionId);
		if(value > temp.getBid().getValue()) {
			Bid bid = temp.getBid();
			bid.setOwner("soapstuff");
			bid.setValue(value);
			b.updateBid(bid);
			return true;
		}else {
			return false;
		}
	}
}
