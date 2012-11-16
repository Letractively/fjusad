package inventory;
import java.io.IOException;
import shared.PMF;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;


public class SellProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String nextJSP = "/getAvailableProducts.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		Long productID = Long.parseLong(request.getParameter("PNO"));
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Product p = pm.getObjectById(Product.class, productID);
		    p.sell(1);
		    pm.makePersistent(p);
		    tx.commit();
		} finally {
            if (tx.isActive()) {
                tx.rollback();
            }
		    pm.close();
		}
		
		response.sendRedirect(nextJSP);
		
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		doGet(request, response);
	}
}//SellProductServlet