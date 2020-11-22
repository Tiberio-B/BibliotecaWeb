package bibliotecaweb.web.servlet.utente.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareUpdateUtenteServlet")
public class PrepareUpdateUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idUt = validateLongParam(request, "idUt", addError);
		if (idUt == null) {
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
			return;
		}
		
		Utente utente = null;
		try { // ottieni utente originale prima della modifica
			utente = MyServiceFactory.getUtenteServiceInstance().carica(idUt);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'utente desiderato.");
			request.getRequestDispatcher("BackToUtentiServlet").forward(request, response);
		}
		request.setAttribute("utenteOld", utente);
		
		initUtenteAttributes(request);

		request.getRequestDispatcher("jsp/utente/update-utente.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
