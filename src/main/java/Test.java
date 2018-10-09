import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Auction;
import entities.Product;
import entities.User;

public class Test {
    private static final String PERSISTENCE_UNIT_NAME = "DAT250Auction";
    private static EntityManagerFactory factory;

	public static void main(String[] args) {
		 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
	       // Auction auction = new Auction("sivert", "kaffe");
	      //  em.persist(auction);
	        Query q = em.createQuery("select s from Tweet s");
	        @SuppressWarnings("unchecked")
			List<Auction> auctions = q.getResultList();

	}

}
