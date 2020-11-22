package bibliotecaweb.web.servlet.autore.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareUpdateAutoreServlet")
public class PrepareUpdateAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idOld = validateLongParam(request, "idAut", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idOld == null) {
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}
		
		Autore autoreOld = null;
		try { // ottiene l'autore da idOld
			autoreOld = MyServiceFactory.getAutoreServiceInstance().carica(idOld);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'autore desiderato.");
			return;
		}
		
		request.setAttribute("autoreOld", autoreOld);
		
		// initAutoreAttributes(request, idOld);
		
		request.getRequestDispatcher("jsp/autore/update-autore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
