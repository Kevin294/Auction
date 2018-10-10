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
public class UserDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	public UserDAO() {

	}

	public void addUser(User user) {
		em.persist(user);
	}

	public void updateUser(User user) {
		em.merge(user);
	}

	public User getUserById(String id) {
		return em.find(User.class, id);
	}

	public void removeUser(User user) {
		em.remove(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		Query query = em.createQuery("SELECT t FROM users t", User.class);
		return query.getResultList();
	}
}
