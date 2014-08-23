package pl.jrola.java.www.vigym.viewcontroller.beans.userview;

import java.io.Serializable;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import pl.jrola.java.www.vigym.model.Utils;
import pl.jrola.java.www.vigym.model.entities.ProfileInfoEntity;
import pl.jrola.java.www.vigym.model.entities.ProfileInfoValueEntity;
import pl.jrola.java.www.vigym.viewcontroller.JSFUtils;

@ManagedBean(name = "historyChartBean")
@RequestScoped
public class HistoryChartBean implements Serializable {

	private static final long serialVersionUID = 8285707332812952216L;

	private String msg;
	private transient LineChartSeries series1;

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
		dateModel = new LineChartModel();
		series1 = new LineChartSeries();
		series1.set("1970-01-06", 0);
		dateModel.addSeries(series1);

		dateModel.setZoom(true);
		dateModel.getAxis(AxisType.Y).setLabel(JSFUtils.getMessage("values"));
		DateAxis axis = new DateAxis(JSFUtils.getMessage("date"));
		axis.setTickAngle(-50);
		axis.setTickFormat("%d-%m-%Y");

		dateModel.getAxes().put(AxisType.X, axis);

	}

	public ProfileInfoEntity getSelectedProfileInfo() {
		return selectedProfileInfo;
	}

	public void setSelectedProfileInfo(ProfileInfoEntity selectedProfileInfo) {
		this.selectedProfileInfo = selectedProfileInfo;

		this.series1.setLabel(selectedProfileInfo.getName());

		dateModel.getSeries().get(0).setData(new HashMap<Object, Number>());
		for (ProfileInfoValueEntity pive : this.selectedProfileInfo
				.getProfileInfoValues()) {
			dateModel
					.getSeries()
					.get(0)
					.set(Utils.getDateAsString(pive.getDate()), pive.getValue());
		}
	}

	public LineChartModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(LineChartModel dateModel) {
		this.dateModel = dateModel;
	}

}