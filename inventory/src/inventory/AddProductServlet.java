package inventory;
import java.io.IOException;
import shared.PMF;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/getAvailableProducts.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		//String productID = request.getParameter("PNO");
		String category_S = request.getParameter("category");
		String desc = request.getParameter("desc");
		String inve_S = request.getParameter("inventory");
		String reodr_S = request.getParameter("reorderPoint");
		int category = 1;
		int inv = 0;
		int reodr = 0;
		try {
			category = Integer.parseInt(category_S);
			inv = Integer.parseInt(inve_S);
			reodr = Integer.parseInt(reodr_S);
		}
		catch (NumberFormatException e){
			//implementation is needed
		}
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Product p = new Product(category, desc, inv, reodr);
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