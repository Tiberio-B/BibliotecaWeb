package bibliotecaweb.web.servlet.libro.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteUpdateLibroServlet")
public class ExecuteUpdateLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idLib = validateLongParam(request, "idLib", addError);
		Long idAut = validateLongParam(request, "idAut", addError);
		String titolo = validateStringParam(request, "titolo", addError);
		String trama = validateStringParam(request, "trama", addError);
		Genere genere = validateEnumParam(request, "genere", Genere.class, addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idLib == null || idAut == null || titolo == null || trama == null || genere == null) {
			request.getRequestDispatcher("jsp/libro/confirm-update-libro.jsp").forward(request, response);
			return;
		}
		
		Autore autore = null;
		try { // ottiene l'autore specificato da idAut, lo setta per il libro e aggiorna il libro
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
			MyServiceFactory.getLibroServiceInstance().aggiorna(new Libro(idLib, titolo, trama, genere, autore));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile aggiornare il libro.");
			request.getRequestDispatcher("jsp/libro/confirm-update-libro.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
	}
}
