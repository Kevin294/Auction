package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.*;

@Singleton
@Startup
public class Temp {
	
	EntityDao dao = new EntityDao();
	
	@PostConstruct
	private void createData() {
		Address address = new Address("Norway", "Bergen", "Nordåsvegen 66", 5235);
		Auction auction = new Auction();
		Bid bid = new Bid(new Double(145.55), "Kevin294");
		Feedback feedback = new Feedback();
		Product product = new Product();
		User user = new User("Kevin294", "Kevin", "Arnesen", address, "kevin@gmail.com", 12345678);
	}
}