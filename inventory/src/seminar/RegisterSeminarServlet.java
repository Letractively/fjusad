package seminar;

import java.io.IOException;
import shared.PMF;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

public class RegisterSeminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/sem_index.jsp";
	private static final String errorJSP = "/sem_error.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		String seminarID_S = request.getParameter("SNO");
		Long seminarID = 0L;
		try{
			seminarID = Long.parseLong(seminarID_S);
		}
		catch (NumberFormatException e){
			//implementation is needed
		}
		String name = request.getParameter("NAME");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean result = true;
		try{ 
			//Registration r =new Registration(name, phone,ssn);
			Seminar s = pm.getObjectById(Seminar.class, seminarID);
			result = s.reserve(name);
			//s.reserve(r);
		} finally {
		    pm.close();
		}
		if (result) {
			response.sendRedirect(nextJSP);
		}
		else {
			response.sendRedirect(errorJSP);	
		}
		
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		doGet(request, response);
	}
}//AddProductServlet