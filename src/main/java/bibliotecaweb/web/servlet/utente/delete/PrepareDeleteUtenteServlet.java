package bibliotecaweb.web.servlet.utente.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareDeleteUtenteServlet")
public class PrepareDeleteUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in rimozione costituiscono errore
		
		Long idUt = validateLongParam(request, "idUt", addError);
		if (idUt == null) {
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
			return;
		}
		
		Utente utente = null;
		try { // ottiene l'utente da idUt
			utente = MyServiceFactory.getUtenteServiceInstance().carica(idUt);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'utente desiderato.");
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
			return;
		}
		request.setAttribute("utente", utente);

		request.getRequestDispatcher("jsp/utente/delete-utente.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
