/*package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.*;

@Startup
@Singleton
public class Temp {
	
	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		Address address = new Address("Norway", "Bergen", "Nordåsvegen 66", 5235);
		
		
		/*Bid bid = new Bid(145.55, "Kevin294");
		Feedback feedback = new Feedback(4.5,"Kevin294","This dude is the real shit" );
		Product product = new Product("Titanium Rolex 2017 Model F", "Accessory", "Watch");
		User user = new User("Kevin294", "Kevin", "Arnesen", address, "kevin@gmail.com", 12345678);
		Auction auction = new Auction(user, product, bid);
      em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();

	}
	
}*/