package bibliotecaweb.web.servlet.autore.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareSearchAutoreServlet")
public class PrepareSearchAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareSearchAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// initAutori(request);
		
		request.getRequestDispatcher("jsp/autore/search-autore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}