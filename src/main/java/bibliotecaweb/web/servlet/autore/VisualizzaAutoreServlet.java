package bibliotecaweb.web.servlet.autore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/VisualizzaAutoreServlet")
public class VisualizzaAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idAut = Long.parseLong(request.getParameter("idAut"));
		
		// ottiene la autore specificata da idAut
		Autore autore = null;
		try {
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		request.setAttribute("autore", autore);
		
		// genera un libro-esempio per la autore
		Libro libro = new Libro();
		libro.setAutore(autore);
		// ottiene tutti gli libri della autore
		List<Libro> libri = null;
		try {
			libri = MyServiceFactory.getLibroServiceInstance().trovaDa(libro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listaLibriAttribute", libri);
		request.setAttribute("filtered", true);
		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
