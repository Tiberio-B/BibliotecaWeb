package bibliotecaweb.web.servlet.libro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/ExecuteSearchLibroServlet")
public class ExecuteSearchLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteSearchLibroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Long idAut = !idAutParam.isEmpty() ? Long.parseLong(idAutParam) : -1;
				
		// Libro libro = new Libro(codice, descrizione, prezzo);
		
		// se specificata, setta la autore
//		if (!(idAut < 0)) {
//			Autore autore = null;
//			try {
//				autore = MyServiceFactory.getAutoreServiceInstance().carica(idAut);
//				libro.setAutore(autore);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		List<Libro> libri = null;
		
		try {
			// libri = MyServiceFactory.getLibroServiceInstance().cerca(libro);
			request.setAttribute("listaLibriAttribute", libri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
	}

}
