package inventory;
import java.io.IOException;

import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
			response.getWriter().println("HELLO");
		}

}//HelloServlet