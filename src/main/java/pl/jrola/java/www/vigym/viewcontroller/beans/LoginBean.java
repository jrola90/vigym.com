package pl.jrola.java.www.vigym.viewcontroller.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
	private String login;
	private String password;

	public LoginBean() {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin() {
		return "index2";
	}

}