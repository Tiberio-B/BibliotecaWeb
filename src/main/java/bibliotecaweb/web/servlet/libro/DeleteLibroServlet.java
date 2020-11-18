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

@WebServlet("/DeleteLibroServlet")
public class DeleteLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteLibroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long id = Long.valueOf(request.getParameter("idParam"));
		
		Libro libro = new Libro();
		libro.setId(id);
		
		try {
			LibroService service = MyServiceFactory.getLibroServiceInstance();
			service.rimuovi(libro);
			request.setAttribute("listaLibriAttribute", service.elenca());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
