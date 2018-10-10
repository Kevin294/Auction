package soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import EJBDAO.AddressDAO;
import entities.Product;
import entities.Address;
import entities.Auction;
import entities.TestEntity;
import entities.User;

@WebService
public class SoapService {
	
	@EJB
	AddressDAO a;
	
	@WebMethod(operationName = "GetAuction")
	public Address getAuction (int id) {
		
		return a.getAddressById(id);
	}
}
