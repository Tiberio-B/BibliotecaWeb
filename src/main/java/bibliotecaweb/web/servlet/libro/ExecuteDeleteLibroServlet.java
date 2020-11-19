package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.libro.LibroService;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ExecuteDeleteLibroServlet")
public class ExecuteDeleteLibroServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long id = validateID(request, "idParam");
		
		Libro libro = new Libro();
		libro.setId(id);
		
		try {
			LibroService service = MyServiceFactory.getLibroServiceInstance();
			service.rimuovi(libro);
			request.setAttribute("listaLibri", service.elenca());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("BackToLibriServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}