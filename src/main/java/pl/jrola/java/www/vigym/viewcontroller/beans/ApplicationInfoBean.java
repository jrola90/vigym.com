package pl.jrola.java.www.vigym.viewcontroller.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean (name="applicationInfoBean")
@ApplicationScoped
public class ApplicationInfoBean {
	
	private String title = "vigym.com";
	
	public ApplicationInfoBean() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}