package bibliotecaweb.web.servlet.utente.update;

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

@WebServlet("/ConfirmUpdateUtenteServlet")
public class ConfirmUpdateUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmUpdateUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idOld = validateLongParam(request, "idUt", addError);
		Long idUt = validateLongParam(request, "idUt", addError);
		String nome = validateStringParam(request, "nome", addError);
		String cognome = validateStringParam(request, "cognome", addError);
		String username = validateStringParam(request, "username", addError);
		Utente.Stato stato = validateEnumParam(request, "stato", Utente.Stato.class, addError);
		String[] ruoliIdInput = request.getParameterValues("ruoliId");
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idUt == null || nome == null || cognome == null || username == null || stato == null) {
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
		}
		
		// conserva utente come utenteOld prima della modifica
		try {
			Utente utenteOld = MyServiceFactory.getUtenteServiceInstance().carica(idOld);
			request.setAttribute("utenteOld", utenteOld);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'utente desiderato.");
			initUtenteAttributes(request);
			request.getRequestDispatcher("jsp/utente/update-utente.jsp").forward(request, response);
		}
		
		
		Set<Ruolo> ruoli = null;
		try { // ottieni il ruolo dall'input utente
			ruoli = MyServiceFactory.getRuoloServiceInstance().carica(ruoliIdInput);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere ai ruoli utente.");
			initUtenteAttributes(request);
			request.getRequestDispatcher("jsp/utente/update-utente.jsp").forward(request, response);
		}
		
		request.setAttribute("utenteNew", new Utente(idOld, nome, cognome, username, stato, ruoli));

		request.getRequestDispatcher("jsp/utente/confirm-update-utente.jsp").forward(request, response);
	}
}
