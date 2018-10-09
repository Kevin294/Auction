package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Address;
import entities.Auction;

@Stateless
public class AddressDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	public void addAddress(Address address) {
		em.persist(address);
	}

	public void updateAddress(Address address) {
		em.merge(address);
	}

	public Address getAddressById(Integer id) {
		return em.find(Address.class, id);
	}

	public void removeAddress(Address address) {
		em.remove(address);
	}
}
