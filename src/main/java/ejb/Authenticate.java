package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import EJBDAO.UserDAO;
import entities.User;

@Stateless
public class Authenticate {

	@EJB
	UserDAO dao;
	public boolean register(User user) {
		User temp = dao.getUserById(user.getUsername());
		if(temp == null) {
			dao.addUser(user);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean authenticate(String username, String password) {
		User user = dao.getUserById(username);
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
}
