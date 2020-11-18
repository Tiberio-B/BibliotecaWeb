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

@WebServlet("/DeleteAutoreServlet")
public class DeleteAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Autore autore = new Autore();
		// autore.setId(id);
		
		try {
			AutoreService service = MyServiceFactory.getAutoreServiceInstance();
			service.rimuovi(autore);
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			request.setAttribute("listaAutori", service.elenca());
		} catch (SQLException s) {
			request.setAttribute("errorMessage", "Impossibile rimuovere una Autore che presenta Libri al suo interno");
			request.setAttribute("listaAutori", request.getParameter("listaAutori"));
			request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
