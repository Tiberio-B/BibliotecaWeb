package bibliotecaweb.web.servlet.libro.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteSearchLibroServlet")
public class ExecuteSearchLibroServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteSearchLibroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean addError = false; // parametri null in ricerca non costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		Long idAut = validateLongParam(request, "idAut", addError);
		String titolo = validateStringParam(request, "titolo", addError);
		String trama = validateStringParam(request, "trama", addError);
		Libro.Genere genere = validateEnumParam(request, "genere", Libro.Genere.class, addError);
		

		List<Libro> libri = null; // risultati della ricerca
		try {
			libri = MyServiceFactory.getLibroServiceInstance().cerca(titolo, trama, genere, idAut);
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "La ricerca ha riscontrato problemi.");
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/search-libro.jsp").forward(request, response);
			return;
		}
		
		if (libri.isEmpty()) {
			addError(request, "Nessun libro presente nella biblioteca soddisfa i parameri di ricerca specificati.");
			initLibroAttributes(request);
			request.getRequestDispatcher("jsp/libro/search-libro.jsp").forward(request, response);
			return;
		}
		
		request.setAttribute("libri", libri);
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
	}

}
