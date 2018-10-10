package EJBDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Auction;
import entities.Bid;

@Stateless
public class BidDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	public BidDAO() {

	}

	public void addBid(Bid bid) {
		em.persist(bid);
	}

	public void updateBid(Bid bid) {
		em.merge(bid);
	}

	public Bid getBidById(Integer id) {
		return em.find(Bid.class, id);
	}

	public void removeBid(Bid bid) {
		em.remove(bid);
	}
}
