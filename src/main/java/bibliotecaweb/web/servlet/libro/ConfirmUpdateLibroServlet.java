package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ConfirmUpdateLibroServlet")
public class ConfirmUpdateLibroServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long idOld = Long.parseLong(request.getParameter("idOld"));
		
		// conserva libro come libroOld prima della modifica
		try {
			Libro libroOld = MyServiceFactory.getLibroServiceInstance().carica(idOld);
			request.setAttribute("libroOld", libroOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ottieni le informazioni aggiornate dall'input utente
		Long idAut = Long.parseLong(request.getParameter("idAut"));
		String titoloInputParam = request.getParameter("titolo");
		String tramaInputParam = request.getParameter("trama");
		String genereInputParam = request.getParameter("genere");
		
		
		// ottieni la autori dall'input utente
		Autore autore = null;
		try {
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Libro libroNew = new Libro(idOld, titoloInputParam, genereInputParam, tramaInputParam);
		// request.setAttribute("libroNew", libroNew);

		//andiamo ai risultati
		request.getRequestDispatcher("jsp/libro/confirm-update-libro.jsp").forward(request, response);
	}
}
