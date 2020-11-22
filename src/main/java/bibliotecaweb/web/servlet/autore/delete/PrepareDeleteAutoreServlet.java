package bibliotecaweb.web.servlet.autore.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareDeleteAutoreServlet")
public class PrepareDeleteAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in rimozione costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idAut = validateLongParam(request, "idAut", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idAut == null) {
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}
		
		Autore autore = null;
		try { // ottiene l'autore da idAut
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'autore desiderato.");
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}
		request.setAttribute("autore", autore);
		
		// initAutoreAttributes(request, idAut);

		request.getRequestDispatcher("jsp/autore/delete-autore.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
