package EJBDAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Auction;
import entities.Product;

@Stateless
public class ProductDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;

	public ProductDAO() {

	}

	public void addProduct(Product product) {
		em.persist(product);
	}

	public void updateProduct(Product product) {
		em.merge(product);
	}

	public Product getProductById(Integer id) {
		return em.find(Product.class, id);
	}

	public void removeProduct(Product product) {
		em.remove(product);
	}
}
