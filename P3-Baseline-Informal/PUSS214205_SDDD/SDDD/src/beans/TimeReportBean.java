package beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** This class is the bean for the web pages "newReport.jsp, editReport.jsp and summaryReport.jsp".*/
public class TimeReportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int week = 0;
	private String username;
	private String signed;
	private int totalTime;
	private int reportID = -1;
	private String role;
	private Map<String, Integer> reportValuesD = new HashMap<String, Integer>();
	private Map<String, Integer> reportValuesI = new HashMap<String, Integer>();
	private Map<String, Integer> reportValuesF = new HashMap<String, Integer>();
	private Map<String, Integer> reportValuesR = new HashMap<String, Integer>();
	private Map<String, Integer> reportValuesActivity = new HashMap<String, Integer>();
	private String[] fieldNamesD = { "sdp_d", "srs_d", "svvs_d", "stldd_d", "svvi_d", "sddd_d", "svvr_d", "ssd_d",
			"final_d", "total_d" };
	private String[] fieldNamesI = { "sdp_i", "srs_i", "svvs_i", "stldd_i", "svvi_i", "sddd_i", "svvr_i", "ssd_i",
			"final_i", "total_i" };
	private String[] fieldNamesF = { "sdp_f", "srs_f", "svvs_f", "stldd_f", "svvi_f", "sddd_f", "svvr_f", "ssd_f",
			"final_f", "total_f" };
	private String[] fieldNamesR = { "sdp_r", "srs_r", "svvs_r", "stldd_r", "svvi_r", "sddd_r", "svvr_r", "ssd_r",
			"final_r", "total_r" };
	private String[] fieldNamesActivity = { "totalMinutes", "functionalTest", "systemTest", "regressionTest", "meeting",
			"lecture", "exercise", "computerExercise", "homeReading", "other" };

	private List<String[]> allFields = new ArrayList<String[]>();
	private List<Map<String, Integer>> reportFields = new ArrayList<Map<String, Integer>>();

	/**
	 * Fetches the week that the report was created for.
	 * 
	 * @return week
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * Sets the week that the time report was created for.
	 * 
	 * @param week
	 */
	public void setWeek(int week) {
		this.week = week;
	}

	/**
	 * Fetches the role of the user.
	 * 
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role of the user.
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Fetches the signed time report.
	 * 
	 * @return signed
	 */
	public String getSigned() {
		return signed;
	}

	/**
	 * Sets the time report as signed.
	 * 
	 * @param signed
	 */
	public void setSigned(String signed) {
		this.signed = signed;
	}

	/**
	 * Fetches the total time that reported.
	 * 
	 * @return totalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}

	/**
	 * Sets the total time for a specified week .
	 * 
	 * @param totalTime
	 */
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * Fetches the ID of the report.
	 * 
	 * @return reportID
	 */
	public int getReportID() {
		return this.reportID;
	}

	/**
	 * Sets ID to the report.
	 * 
	 * @param reportID
	 */
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	/**
	 * Sets the username for the current user.
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Fetches the username.
	 * 
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Fetches a list of the D reported values, the values are in minutes.
	 * 
	 * @return map reportValuesD
	 */
	public Map<String, Integer> getReportValuesD() {
		return reportValuesD;
	}

	/**
	 * Fetches a list of the I reported values, the values are in minutes.
	 * 
	 * @return map reportValuesI
	 */
	public Map<String, Integer> getReportValuesI() {
		return reportValuesI;
	}

	/**
	 * Fetches a list of the F reported values, the values are in minutes.
	 * 
	 * @return map reportValuesF
	 */
	public Map<String, Integer> getReportValuesF() {
		return reportValuesF;
	}

	/**
	 * Fetches a list of the R reported values, the values are in minutes.
	 * 
	 * @return map reportValuesR
	 */
	public Map<String, Integer> getReportValuesR() {
		return reportValuesR;
	}

	/**
	 * Fetches a list of the Activity reported values, the values are in minutes.
	 * 
	 * @return map reportValuesActivity
	 */
	public Map<String, Integer> getReportValuesActivity() {
		return reportValuesActivity;
	}

	/**
	 * 
	 * @param D        The map of the D reported values
	 * @param I        The map of the I reported values
	 * @param F        The map of the F reported values
	 * @param R        The map of the R reported values
	 * @param Activity The map of the Activity reported values
	 * @param time     Total time
	 */
	public void populateBean(Map<String, Integer> D, Map<String, Integer> I, Map<String, Integer> F,
			Map<String, Integer> R, Map<String, Integer> Activity, Integer time) {
		reportValuesD = D;
		reportValuesI = I;
		reportValuesF = F;
		reportValuesR = R;
		reportValuesActivity = Activity;
		totalTime = time;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void populateBean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allFields.add(fieldNamesD);
		allFields.add(fieldNamesI);
		allFields.add(fieldNamesF);
		allFields.add(fieldNamesR);
		allFields.add(fieldNamesActivity);

		reportFields.add(reportValuesD);
		reportFields.add(reportValuesI);
		reportFields.add(reportValuesF);
		reportFields.add(reportValuesR);
		reportFields.add(reportValuesActivity);

		for (int i = 0; i < allFields.size(); i++) {
			for (int j = 0; j < allFields.get(i).length; j++) {
				String Input = request.getParameter(allFields.get(i)[j]);
				if (Input == null || Input == "") {
					reportFields.get(i).put(allFields.get(i)[j], 0);
				} else {
					reportFields.get(i).put(allFields.get(i)[j], Integer.parseInt(Input));
				}
			}
		}

		String Input = request.getParameter("totalMinutes");
		totalTime = Integer.parseInt(Input);
	}

}
