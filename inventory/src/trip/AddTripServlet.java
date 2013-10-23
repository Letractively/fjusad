package trip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AddTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/getAllTrips.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		int kilometers = 0;
		int days = 0;
		try {
			String kilometers_s = request.getParameter("kilometers");
			kilometers = Integer.parseInt(kilometers_s);
			String days_s = request.getParameter("days");
			days = Integer.parseInt(days_s);
		} catch (NumberFormatException e) {
			// leave kilometers and days as 0 for now
			// implementation is needed
		}

		boolean ok = PersistenceTrip.save(category, name, days, kilometers);
		if (ok) {
			response.sendRedirect(nextJSP);
		}
		// else implementation is needed
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
}// AddTripServlet