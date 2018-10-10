package soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import EJBDAO.ProductDAO;
import entities.Auction;
import entities.Product;

@WebService
public class SoapService {
	
	@EJB
	ProductDAO p;
	
	@WebMethod(operationName = "GetAuction")
	public Product getAuction (int id) {
		
		return p.getProductById(id);
	}
}
