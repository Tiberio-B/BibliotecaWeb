package bibliotecaweb.web.servlet.utente.search;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Ruolo.Codice;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteSearchUtenteServlet")
public class ExecuteSearchUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteSearchUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean addError = false; // parametri null in ricerca non costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		String cognome = validateStringParam(request, "cognome", addError);
		String nome = validateStringParam(request, "nome", addError);	
		String username = validateStringParam(request, "username", addError);
		Utente.Stato stato = validateEnumParam(request, "stato", Utente.Stato.class, addError);
		
		String[] ruoliIdInput = request.getParameterValues("ruoliId");
		
		List<Utente> utenti = null; // risultati della ricerca
		try {
			utenti = MyServiceFactory.getUtenteServiceInstance().cerca(nome, cognome, username, stato, ruoliIdInput);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "La ricerca ha riscontrato problemi.");
			initUtenteAttributes(request);
			request.getRequestDispatcher("jsp/utente/search-utente.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("utenti", utenti);
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/utente/utenti.jsp").forward(request, response);
	}

}
