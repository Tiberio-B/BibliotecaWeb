package bibliotecaweb.web.servlet.autore;

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
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/DeleteAutoreServlet")
public class DeleteAutoreServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idAut = validateID(request, "idAut");
		if (idAut < 0) {
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
		}
		
		try {
			AutoreService service = MyServiceFactory.getAutoreServiceInstance();
			service.rimuovi(idAut);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (SQLException s) {
			request.setAttribute("errorMessage", "Impossibile rimuovere una Autore che presenta Libri al suo interno");
			request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("BackToAutoriServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
