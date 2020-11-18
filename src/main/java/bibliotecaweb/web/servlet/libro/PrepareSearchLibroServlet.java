package bibliotecaweb.web.servlet.libro;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/PrepareSearchLibroServlet")
public class PrepareSearchLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareSearchLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Autore> autori = null;
		try {
			autori = MyServiceFactory.getAutoreServiceInstance().elenca();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Collections.sort(autori);
		request.setAttribute("autori", autori);
		
		
		Libro.Genere[] generi = Libro.Genere.values();
		Arrays.sort(generi);
		request.setAttribute("generi", generi);

		request.getRequestDispatcher("jsp/libro/search-libro.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}