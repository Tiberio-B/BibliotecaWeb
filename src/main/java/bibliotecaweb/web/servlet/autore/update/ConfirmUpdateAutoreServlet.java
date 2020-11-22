package bibliotecaweb.web.servlet.autore.update;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ConfirmUpdateAutoreServlet")
public class ConfirmUpdateAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmUpdateAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore

		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idOld = validateLongParam(request, "idAut", addError);
		String nome = validateStringParam(request, "nome", addError);
		String cognome = validateStringParam(request, "cognome", addError);
		Date ddn = validateDateParam(request, "ddn", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idOld == null || nome == null || cognome == null || ddn == null) {
			request.getRequestDispatcher("jsp/autore/update-autore.jsp").forward(request, response);
			return;
		}
		
		Autore autoreOld = null;
		try { // conserva l'autore come autoreOld prima della modifica
			autoreOld = MyServiceFactory.getAutoreServiceInstance().carica(idOld);
			request.setAttribute("autoreOld", autoreOld);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'autore desiderato.");
			request.getRequestDispatcher("jsp/autore/update-autore.jsp").forward(request, response);
		}
		
		request.setAttribute("autoreNew", new Autore(idOld, nome, cognome, ddn, autoreOld.getLibri()));

		request.getRequestDispatcher("jsp/autore/confirm-update-autore.jsp").forward(request, response);
	}
}
