package bibliotecaweb.web.servlet.utente.update;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteUpdateUtenteServlet")
public class ExecuteUpdateUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a nullLong idUt = validateLongParam(request, "idUt");
		Long idUt = validateLongParam(request, "idUt", addError);
		String nome = validateStringParam(request, "nome", addError);
		String cognome = validateStringParam(request, "cognome", addError);
		String username = validateStringParam(request, "username", addError);
		Utente.Stato stato = validateEnumParam(request, "stato", Utente.Stato.class, addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idUt == null || nome == null || cognome == null || username == null || stato == null) {
			request.getRequestDispatcher("jsp/utente/confirm-update-utente.jsp").forward(request,response);
			return;
		}
				
		String[] ruoliIdInput = request.getParameterValues("ruoliId");
		Set<Ruolo> ruoli = null;
		try { // ottiene i ruoli specificati da ruoliIdInput, li setta per l'utente e lo aggiorna
			ruoli = MyServiceFactory.getRuoloServiceInstance().carica(ruoliIdInput);
			MyServiceFactory.getUtenteServiceInstance().aggiorna(new Utente(idUt, nome, cognome, username, stato, ruoli));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile aggiornare l'utente.");
			request.getRequestDispatcher("jsp/utente/confirm-update-utente.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
	}
}
