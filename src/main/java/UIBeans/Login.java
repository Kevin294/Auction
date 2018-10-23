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
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: "+auth.authenticate(username, password), null));
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute(username, user);
			return "loggedin";
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status: "+auth.authenticate(username, password), null));
			return null;
		}
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