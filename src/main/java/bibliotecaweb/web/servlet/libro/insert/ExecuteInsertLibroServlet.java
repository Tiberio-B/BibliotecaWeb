package bibliotecaweb.web.servlet.libro.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteInsertLibroServlet")
public class ExecuteInsertLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in inserimento costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idAut = validateLongParam(request, "idAut", addError);
		String titolo = validateStringParam(request, "titolo", addError);
		String trama = validateStringParam(request, "trama", addError);
		Libro.Genere genere = validateEnumParam(request, "genere", Libro.Genere.class, addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idAut == null || titolo == null || trama == null || genere == null) {
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/insert-libro.jsp").forward(request, response);
			return;
		}
		
		Autore autore = null;
		try {
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
			MyServiceFactory.getLibroServiceInstance().inserisci(new Libro(titolo, trama, genere, autore));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile inserire il libro specificato.");
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/insert-libro.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToLibriServlet").forward(request, response);

	}
}
