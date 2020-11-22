package bibliotecaweb.web.servlet.autore.insert;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.autore.AutoreService;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteInsertAutoreServlet")
public class ExecuteInsertAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in inserimento costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		String nome = validateStringParam(request, "nome", addError);
		String cognome = validateStringParam(request, "cognome", addError);
		Date ddn = validateDateParam(request, "ddn", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (nome == null || cognome == null || ddn == null) {
			request.getRequestDispatcher("jsp/autore/insert-autore.jsp").forward(request, response);
			return;
		}
		
		try {
			MyServiceFactory.getAutoreServiceInstance().inserisci(new Autore(nome, cognome, ddn));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile inserire l'autore desiderato.");
			request.getRequestDispatcher("jsp/autore/insert-autore.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
	}

}
