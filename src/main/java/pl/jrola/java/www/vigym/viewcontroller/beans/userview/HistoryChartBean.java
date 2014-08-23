package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import pl.jrola.java.www.vigym.model.entities.ProfileInfoEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "historyChartBean")
@ViewScoped
public class HistoryChartBean implements Serializable {

	private static final long serialVersionUID = 8285707332812952216L;

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private ProfileInfoEntity selectedProfileInfo;

	private LineChartModel dateModel;

	public HistoryChartBean() {

	}

	@PostConstruct
	public void postConstruct() {
		msg = "bbb";
		dateModel = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		series1.setLabel("Series 1");

		/*if (selectedProfileInfo != null) {
			for (ProfileInfoValueEntity pive : selectedProfileInfo.getProfileInfoValues()) {
				series1.set(pive.getDate(), pive.getValue());
			}
		}*/
		
		series1.set("2014-11-11", 1);
		
		dateModel.addSeries(series1);

		dateModel.setTitle(JSFUtils.getMessage("zoom"));
		dateModel.setZoom(true);
		dateModel.getAxis(AxisType.Y).setLabel(JSFUtils.getMessage("values"));
		DateAxis axis = new DateAxis(JSFUtils.getMessage("date"));
		axis.setTickAngle(-50);
		axis.setMax(new Date());
		axis.setTickFormat("%b %#d, %y");

		dateModel.getAxes().put(AxisType.X, axis);
	}
 
	public ProfileInfoEntity getSelectedProfileInfo() {
		return selectedProfileInfo;
	}

	public void setSelectedProfileInfo(ProfileInfoEntity selectedProfileInfo) {
		this.selectedProfileInfo = selectedProfileInfo;
	}

	public LineChartModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(LineChartModel dateModel) {
		this.dateModel = dateModel;
	}

}