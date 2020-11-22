package bibliotecaweb.web.servlet.libro.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.libro.LibroService;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteDeleteLibroServlet")
public class ExecuteDeleteLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in rimozione costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idLib = validateLongParam(request, "idLib", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idLib == null) {
			// initLibroAttributes(request);
			request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
			return;
		}
				
		try { // rimuove il libro specificato da idLib
			MyServiceFactory.getLibroServiceInstance().rimuovi(idLib);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile rimuovere il libro specificato.");
			// initLibroAttributes(request);
			request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
			return;
		}

		request.getRequestDispatcher("BackToLibriServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
