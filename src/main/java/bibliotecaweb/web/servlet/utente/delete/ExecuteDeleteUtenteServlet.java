package bibliotecaweb.web.servlet.utente.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.autore.AutoreService;
import bibliotecaweb.service.utente.UtenteService;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteDeleteUtenteServlet")
public class ExecuteDeleteUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean addError = true; // parametri null in rimozione costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idUt = validateLongParam(request, "idUt", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idUt == null) {
			// initUtenteAttributes(request);
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
			return;
		}
		
		try { // rimuove l'utente specificato da idUt
			MyServiceFactory.getUtenteServiceInstance().rimuovi(idUt);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile rimuovere l'utente specificato.");
			// initUtenteAttributes(request);
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
