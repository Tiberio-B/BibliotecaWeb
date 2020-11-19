package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ExecuteInsertLibroServlet")
public class ExecuteInsertLibroServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// validazione input utente, se fallisce reindirizza con un messaggio di errore appropriato
		String titolo = validateStringParam(request, "titolo");
		String trama = validateStringParam(request, "trama");
		Genere genere = Genere.valueOf(request.getParameter("genere"));
		Long idAut = validateID(request, "idAut");
		if (idAut < 0 || titolo == null || trama == null) {
			request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
		}
		
		Autore autore = null;
		try {
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
			Libro libro = new Libro(titolo, trama, genere, autore);
			MyServiceFactory.getLibroServiceInstance().inserisci(libro);
			request.setAttribute("listaLibri", MyServiceFactory.getLibroServiceInstance().elenca());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("BackToLibriServlet").forward(request, response);

	}
}
