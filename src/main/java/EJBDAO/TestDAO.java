package EJBDAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.TestEntity;
import entities.User;

@Stateless
public class TestDAO {

	@PersistenceContext(unitName = "DAT250Auction")
	private EntityManager em;
	
	public void setTestEntity(TestEntity te) {
		em.persist(te);
	}
	
	public TestEntity getTestEntity(String id) {
		return em.find(TestEntity.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<TestEntity> getAllTestEntities(){
		Query query = em.createQuery("SELECT t FROM testing t", TestEntity.class);
		return query.getResultList();
	}
}

