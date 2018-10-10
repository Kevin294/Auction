package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import EJBDAO.TestDAO;
import entities.TestEntity;

@Stateless
public class TestEJB {
	@EJB
	TestDAO testdao;

	public void addTestEntity(TestEntity te) {
		testdao.setTestEntity(te);
	}
	
	public TestEntity getTestEntity(String id) {
		return testdao.getTestEntity(id);
	}
	
	public List<TestEntity> getAllTestEntities(){
		return testdao.getAllTestEntities();
	}
}

	
