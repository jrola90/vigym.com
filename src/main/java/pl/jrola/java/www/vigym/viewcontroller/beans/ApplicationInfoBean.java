package pl.jrola.java.www.vigym.viewcontroller.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import pl.jrola.java.www.vigym.model.Utils;

@ManagedBean (name="applicationInfoBean")
@ApplicationScoped
public class ApplicationInfoBean {
	
	private String title = "vigym.com";
	private String dateFormat = Utils.DATE_FORMAT;
	
	public ApplicationInfoBean() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
}