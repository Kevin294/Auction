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
		Bid bid = new Bid(new Double(145.55), "Kevin294");
		Feedback feedback = new Feedback(4.5,"Kevin294","This dude is the real shit" );
		Product product = new Product("Titanium Rolex 2017 Model F", "Accessory", "Watch");
		User user = new User("Kevin294", "Kevin", "Arnesen", address, "kevin@gmail.com", 12345678);
		Auction auction = new Auction(bid, product, user);

		dao.persist(address);
		dao.persist(bid);
		dao.persist(feedback);
		dao.persist(product);
		dao.persist(user);
		dao.persist(auction);
		


	}
}