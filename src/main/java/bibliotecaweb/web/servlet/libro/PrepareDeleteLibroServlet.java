package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/PrepareDeleteLibroServlet")
public class PrepareDeleteLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long id = Long.valueOf(request.getParameter("idParam"));
		Libro libro = null;
		try {
			libro = MyServiceFactory.getLibroServiceInstance().carica(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("libroAttr", libro);

		request.getRequestDispatcher("jsp/libro/delete-libro.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}