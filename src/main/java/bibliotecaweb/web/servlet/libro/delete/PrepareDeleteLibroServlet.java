package bibliotecaweb.web.servlet.libro.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareDeleteLibroServlet")
public class PrepareDeleteLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in rimozione costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idLib = validateLongParam(request, "idLib", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idLib == null) {
			request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
			return;
		}
		
		Libro libro = null;
		try { // ottiene il libro da id
			libro = MyServiceFactory.getLibroServiceInstance().carica(idLib);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere al libro desiderato.");
			request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
			return;
		}
		request.setAttribute("libro", libro);

		request.getRequestDispatcher("jsp/libro/delete-libro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
