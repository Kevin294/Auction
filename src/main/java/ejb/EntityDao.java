package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EntityDao {
    // Injected database connection:
	@PersistenceContext(unitName="DAT250Auction")
    private EntityManager em;

    
    public <T> void persist(T object) {
        em.persist(object);
    }

    
    @SuppressWarnings("unchecked")
	public <T> List<T> getAll(String type) {

        Query query = em.createQuery("SELECT t FROM "+type.toLowerCase()+" t");
        List<T> list = new ArrayList<T>();
        list = query.getResultList();
        return list;
    }
}