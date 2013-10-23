package seminar;
import java.io.IOException;
import java.util.Date;

import shared.PMF;
import shared.MyDateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

public class AddSeminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/sem_index.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		String seminarID = request.getParameter("SID");
		String max_S = request.getParameter("MAX");
		Date seminarDate = MyDateUtil.getTodayDate(); 
		int max = 0;
	    try {
	    seminarDate = MyDateUtil.parse(request.getParameter("DATE")); 
		max = Integer.parseInt(max_S);
	    } catch (NumberFormatException e){
	    	//implementation is needed
	    }
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