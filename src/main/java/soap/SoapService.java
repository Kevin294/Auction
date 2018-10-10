package soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import EJBDAO.AuctionDAO;
import entities.Product;
import entities.Address;
import entities.Auction;
import entities.TestEntity;
import entities.User;

@WebService
public class SoapService {
	
	@EJB
	AuctionDAO a;
	
	@WebMethod(operationName = "GetAuction")
	public Auction getAuction (int id) {
		
		return a.getAuctionById(id);
	}
}
