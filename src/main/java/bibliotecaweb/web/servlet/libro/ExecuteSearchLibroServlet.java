package bibliotecaweb.web.servlet.libro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
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
		
		String titoloInput = request.getParameter("titolo");
		String titolo = titoloInput.isEmpty() ? null : titoloInput;
		String tramaInput = request.getParameter("trama");
		String trama = tramaInput.isEmpty() ? null : tramaInput;
		String genereInput = request.getParameter("genere");
		Libro.Genere genere = genereInput.isEmpty() ? null : Genere.valueOf(genereInput);
		Long autoreId = Long.parseLong(request.getParameter("autoreId"));
		
		Autore autore = null;
		if (autoreId != -1) {
			try {
				autore = MyServiceFactory.getAutoreServiceInstance().carica(autoreId);
				request.setAttribute("autore", autore);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Libro libro = new Libro(titolo, trama, genere, autore);
		
		List<Libro> libri = null;
		try {
			libri = MyServiceFactory.getLibroServiceInstance().cerca(libro);
			request.setAttribute("listaLibri", libri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
	}

}
