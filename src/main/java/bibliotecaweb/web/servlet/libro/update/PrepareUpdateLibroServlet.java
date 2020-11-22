package bibliotecaweb.web.servlet.libro.update;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareUpdateLibroServlet")
public class PrepareUpdateLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in modifica costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idOld = validateLongParam(request, "idLib", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idOld == null) {
			request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
			return;
		}
		
		Libro libroOld = null;
		try { // ottieni libro originale come libroOld prima della modifica
			libroOld = MyServiceFactory.getLibroServiceInstance().carica(idOld);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere al libro desiderato.");
			request.getRequestDispatcher("BackToLibriServlet").forward(request, response);
		}
		request.setAttribute("libroOld", libroOld);
		
		initLibroAttributes(request);

		request.getRequestDispatcher("jsp/libro/update-libro.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected void backToLibri() {
		
	}
}
