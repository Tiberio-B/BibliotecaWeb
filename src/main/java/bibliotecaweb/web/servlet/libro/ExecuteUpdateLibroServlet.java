package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ExecuteUpdateLibroServlet")
public class ExecuteUpdateLibroServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String titoloParam = validateStringParam(request, "titolo");
		String tramaParam = validateStringParam(request, "trama");
		String genereParam = validateStringParam(request, "genere");
		if (titoloParam == null || tramaParam == null || genereParam == null) {
			request.getRequestDispatcher("BackToLibriServlet").forward(request,response);
			return;
		}
		Genere genere = Genere.valueOf(genereParam);
				
		// validazione campo ID, se fallisce reindirizza
		Long idLib = validateID(request, "idLib");
		Long idAut = validateID(request, "idAut");
		if (idLib < 0 || idAut < 0) {
			request.getRequestDispatcher("BackToLibriServlet").forward(request,response);
			return;
		}
		
		Libro libro = new Libro(idLib, titoloParam, tramaParam, genere);
		Autore autore = null;
		
		// ottiene l'autore specificato da idAut e lo setta per il libro
		try {
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
			libro.setAutore(autore);
			MyServiceFactory.getLibroServiceInstance().aggiorna(libro);

			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
	}
}
