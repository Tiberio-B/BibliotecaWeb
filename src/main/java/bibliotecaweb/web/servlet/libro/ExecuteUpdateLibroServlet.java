package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ExecuteUpdateLibroServlet")
public class ExecuteUpdateLibroServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Libro libro = new Libro(idLib, codiceParam, descrizioneParam, prezzo);
		Autore autore = null;
		
		// ottiene la autore specificata da idAut e la setta per l'libro
		try {
			// autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
			// libro.setAutore(autore);
			// MyServiceFactory.getLibroServiceInstance().aggiorna(libro);
			
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().elenca());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
	}
}
