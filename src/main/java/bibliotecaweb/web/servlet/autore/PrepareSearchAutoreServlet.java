package bibliotecaweb.web.servlet.autore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/PrepareSearchAutoreServlet")
public class PrepareSearchAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareSearchAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("jsp/autore/search-autore.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}