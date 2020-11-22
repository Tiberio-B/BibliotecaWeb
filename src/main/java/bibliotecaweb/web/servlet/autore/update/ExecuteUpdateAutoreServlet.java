package bibliotecaweb.web.servlet.autore.update;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteUpdateAutoreServlet")
public class ExecuteUpdateAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idAut = validateLongParam(request, "idAut", addError);
		String nome = validateStringParam(request, "nomeNew", addError);
		String cognome = validateStringParam(request, "cognomeNew", addError);
		Date ddn = validateDateParam(request, "ddn", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idAut == null || nome == null || cognome == null || ddn == null) {
			request.getRequestDispatcher("jsp/autore/confirm-update-autore.jsp").forward(request,response);
			return;
		}
		
		Set<Libro> libri = null;
		try { // ottiene i libri dell'autore specificato da idAut
			libri =  MyServiceFactory.getAutoreServiceInstance().carica(idAut).getLibri();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere ai libri dell'autore specificato.");
			request.getRequestDispatcher("jsp/autore/confirm-update-autore.jsp").forward(request, response);
			return;
		}
				
		try { // aggiorna l'autore
			MyServiceFactory.getAutoreServiceInstance().aggiorna(new Autore(idAut, nome, cognome, ddn, libri));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile aggiornare l'autore.");
			request.getRequestDispatcher("jsp/autore/confirm-update-autore.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
	}
}
