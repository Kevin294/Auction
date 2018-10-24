package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import EJBDAO.UserDAO;
import entities.Address;
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
	
	public User authenticate(String username, String password) {
		if(username.isEmpty() || password.isEmpty()) {
			return null;
		}
		User user = dao.getUserById(username);
		if(user == null) {
			return null;
		}
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			return user;
		}else {
			return null;
		}
	}
	
	public boolean validateUsername(String username) {
		if(username.isEmpty()) {
			return false;
		}
		User temp = dao.getUserById(username);
		if(temp == null) {
			return true;
		} else {
			return false;
		}
	}
}
