package pl.jrola.java.www.vigym.viewcontroller;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public abstract class JSFUtils {

	public static Object getRequestParameter(String paramName) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(paramName);
	}

	public static String getMessage(String name) {

		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle text = ResourceBundle.getBundle("lang", context
				.getViewRoot().getLocale());
		return text.getString(name);
	}

	public static String getMessage(String name, String[] params,
			String[] values) {
		String text = getMessage(name);

		int size = params.length;
		for (int i = 0; i < size; i++) {
			text = text.replace(":" + params[i], values[i]);
		}

		return text;
	}

}