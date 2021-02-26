

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TimeReportManagementServlet
 */
@WebServlet("/TimeReportManagementServlet")
public class TimeReportManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase db = new DataBase();
		HttpSession session = request.getSession();
		TimeReportManagementBean trmb = new TimeReportManagementBean();		
		trmb.populateBean(db.signedUnsignedTimeReports());
		session.setAttribute("TimeReportManagementBean", trmb);
		TimeReportManagementBean trmb1 = new TimeReportManagementBean();
		trmb1 = (TimeReportManagementBean) request.getAttribute("TimeReportManagementBean");
		
		for(Map.Entry<String, Boolean> entry : trmb1.getTimeReportList().entrySet()){
			db.signUnsignTimeReport(entry.getKey(), entry.getValue());
		}
		
		response.sendRedirect("signreport.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
