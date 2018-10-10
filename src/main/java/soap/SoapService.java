package soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import EJBDAO.AddressDAO;
import entities.Address;
import entities.Auction;
import entities.Product;

@WebService
public class SoapService {
	
	@EJB
	AddressDAO a;
	
	@WebMethod(operationName = "GetAuction")
	public String getAuction (int id) {
		
		return a.getAddressById(id).getCity();
	}
}
