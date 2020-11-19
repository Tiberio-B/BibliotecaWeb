package bibliotecaweb.web.servlet.libro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/PrepareUpdateLibroServlet")
public class PrepareUpdateLibroServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long idOld = Long.parseLong(request.getParameter("idParam"));
		
		Libro libroOld = null;
		try {
			libroOld = MyServiceFactory.getLibroServiceInstance().carica(idOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("libroOld", libroOld);

		request.getRequestDispatcher("jsp/libro/update-libro.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
