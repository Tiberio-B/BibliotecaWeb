package bibliotecaweb.web.servlet.autore.delete;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.autore.AutoreService;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteDeleteAutoreServlet")
public class ExecuteDeleteAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteAutoreServlet() {
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
		
		try {
			MyServiceFactory.getAutoreServiceInstance().rimuovi(idAut);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile rimuovere una Autore che presenta Libri al suo interno");
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
