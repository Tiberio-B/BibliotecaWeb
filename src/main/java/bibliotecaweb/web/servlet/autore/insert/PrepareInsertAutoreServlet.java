package bibliotecaweb.web.servlet.autore.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareInsertAutoreServlet")
public class PrepareInsertAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareInsertAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/autore/insert-autore.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
