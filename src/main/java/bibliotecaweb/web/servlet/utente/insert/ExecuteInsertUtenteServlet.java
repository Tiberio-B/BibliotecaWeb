package bibliotecaweb.web.servlet.utente.insert;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteInsertUtenteServlet")
public class ExecuteInsertUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in inserimento costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idUt = validateLongParam(request, "idUt", addError);
		String nome = validateStringParam(request, "nome", addError);
		String cognome = validateStringParam(request, "cognome", addError);
		String username = validateStringParam(request, "username", addError);
		Utente.Stato stato = validateEnumParam(request, "stato", Utente.Stato.class, addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idUt == null || nome == null || cognome == null || username == null || stato == null) {
			initUtenteAttributes(request);
			request.getRequestDispatcher("jsp/utente/insert-utente.jsp").forward(request,response);
			return;
		}
				
		String[] ruoliIdInput = request.getParameterValues("ruoliId");
		Set<Ruolo> ruoli = null;
		try {
			ruoli = MyServiceFactory.getRuoloServiceInstance().carica(ruoliIdInput);
			MyServiceFactory.getUtenteServiceInstance().inserisci(new Utente(idUt, nome, cognome, username, stato, ruoli));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile inserire l'utente specificato.");
			initUtenteAttributes(request);
			request.getRequestDispatcher("jsp/utente/insert-utente.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
	}
}
