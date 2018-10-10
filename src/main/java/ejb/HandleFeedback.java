package ejb;

import javax.ejb.EJB;

import EJBDAO.FeedbackDAO;
import EJBDAO.UserDAO;
import entities.Feedback;
import entities.User;

public class HandleFeedback {

	@EJB
	FeedbackDAO dao;
	@EJB
	UserDAO userdao;
	
	public void newFeedback(String target, String message, double stars, User sender) {
		Feedback feedback = new Feedback(stars, message, sender.getUsername(), userdao.getUserById(target));
		dao.addFeedback(feedback);
	}
	
}
