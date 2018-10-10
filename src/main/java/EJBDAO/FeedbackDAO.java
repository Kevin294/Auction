package EJBDAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Auction;
import entities.Feedback;
import entities.User;

@Stateless
public class FeedbackDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	public FeedbackDAO() {

	}

	public void addFeedback(Feedback feedback) {
		em.persist(feedback);
	}

	public void updateFeedback(Feedback feedback) {
		em.merge(feedback);
	}

	public Feedback getFeedbackById(Integer id) {
		return em.find(Feedback.class, id);
	}

	public void removeFeedback(Feedback feedback) {
		em.remove(feedback);
	}

	@SuppressWarnings("unchecked")
	public List<Feedback> getAllFeedbacksByUser(User user) {
		Query query = em.createQuery("SELECT t FROM feedback t WHERE t.username = " + user.getUsername(),
				Feedback.class);
		return query.getResultList();
	}
}
