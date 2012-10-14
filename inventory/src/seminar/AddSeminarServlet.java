package seminar;
import java.io.IOException;
import shared.PMF;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

public class AddSeminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/sem_index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		request.setCharacterEncoding("BIG5");
		String seminarID = request.getParameter("SID");
		String seminarDate = request.getParameter("DATE");
		String max_S = request.getParameter("MAX");
		int max = Integer.parseInt(max_S);
	
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Seminar p = new Seminar(seminarID,seminarDate, max);
			pm.makePersistent(p);
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