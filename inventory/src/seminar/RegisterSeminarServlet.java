package seminar;

import java.io.IOException;
import shared.PMF;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

public class RegisterSeminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/sem_index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		request.setCharacterEncoding("BIG5");
		String seminarID = request.getParameter("SNO");
		String name = request.getParameter("NAME");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{ 
			//Registration r =new Registration(name, phone,ssn);
			Seminar s = pm.getObjectById(Seminar.class, seminarID);
			s.reserve(name);
			//s.reserve(r);
		} finally {
		    pm.close();
		}
		
		response.sendRedirect(nextJSP);
		
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		doGet(request, response);
	}
}//AddProductServlet