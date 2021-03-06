package UIBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ejb.Authenticate;
import entities.User;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class Login {

	String username;
	String password;
	boolean status = false;
	@EJB
	Authenticate auth;
	
	public String submit() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = auth.authenticate(username, password);
		if(user != null) {
			status = true;
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Logged in: "+auth.authenticate(username, password).getUsername(), null));
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("currentuser", user);
			return "loggedin";
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Failed", null));
			return null;
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		FacesContext context = FacesContext.getCurrentInstance();
		User user = (User) session.getAttribute("currentuser");
		if (user != null) {
			session.invalidate();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Logged out", null));
			return "login";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: Please login to logout:)", null));
		return "login";
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
    
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}