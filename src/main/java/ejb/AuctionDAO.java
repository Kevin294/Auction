package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Auction;

@Stateless
public class AuctionDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	public AuctionDAO() {

	}

	public void addAuction(Auction auction) {
		em.persist(auction);
	}

	public void updateAuction(Auction auction) {
		em.merge(auction);
	}

	public Auction getAuctionById(Integer id) {
		return em.find(Auction.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Auction> getAllAuctions() {
		Query query = em.createQuery("SELECT t FROM auction t", Auction.class);
		return query.getResultList();

	}

	public void removeAuction(Auction auction) {
		em.remove(auction);
	}
}
