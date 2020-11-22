package bibliotecaweb.web.servlet.autore;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/VisualizzaAutoreServlet")
public class VisualizzaAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean addError = true; // parametri null in visualizzazione costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idAut = validateLongParam(request, "idAut", addError);
		
		// se almeno uno dei parametri obbligatori è vuoto/invalido, reindirizzamento con messaggio di errore appropriato
		if (idAut == null) {
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}
		
		Autore autore = null;
		Set<Libro> libri = new HashSet<>();
		try { // ottieni autore corrispondente ad idAut con i suoi libri
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
			libri = autore.getLibri();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere all'autore desiderato o ai suoi libri.");
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}
		
		if (libri.size() > 0) {
			request.setAttribute("libriByAutore", libri);
		}
		else {
			addError(request, "L'autore non presenta libri in questa biblioteca.");
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
			return;
		}
		request.setAttribute("autore", autore);
		request.setAttribute("filtered", true);
		request.getRequestDispatcher("jsp/libro/libri-by-autore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
