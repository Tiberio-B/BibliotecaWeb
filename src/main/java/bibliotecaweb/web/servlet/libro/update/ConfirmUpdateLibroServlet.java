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

@WebServlet("/ConfirmUpdateLibroServlet")
public class ConfirmUpdateLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore

		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idOld = validateLongParam(request, "idOld", addError);
		Long idAut = validateLongParam(request, "idAut", addError);
		String titolo = validateStringParam(request, "titolo", addError);
		String trama = validateStringParam(request, "trama", addError);
		Genere genere = validateEnumParam(request, "genere", Genere.class, addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idOld == null || idAut == null || titolo == null || trama == null || genere == null) {
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/update-libro.jsp").forward(request, response);
			return;
		}
		
		try { // conserva libro come libroOld prima della modifica
			Libro libroOld = MyServiceFactory.getLibroServiceInstance().carica(idOld);
			request.setAttribute("libroOld", libroOld);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere al libro desiderato.");
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/update-libro.jsp").forward(request, response);
		}
		
		Autore autore = null;
		try { // ottieni l'autore dall'input utente
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'autore desiderato.");
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/update-libro.jsp").forward(request, response);
		}
		
		request.setAttribute("libroNew", new Libro(idOld, titolo, trama, genere, autore));

		request.getRequestDispatcher("jsp/libro/confirm-update-libro.jsp").forward(request, response);
	}
}
