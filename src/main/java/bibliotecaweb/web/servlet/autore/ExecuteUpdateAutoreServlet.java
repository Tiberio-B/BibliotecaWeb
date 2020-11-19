package bibliotecaweb.web.servlet.autore;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.autore.AutoreService;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ExecuteUpdateAutoreServlet")
public class ExecuteUpdateAutoreServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteUpdateAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = validateStringParam(request, "nomeNew");
		String cognome = validateStringParam(request, "cognomeNew");
		// String ddnParam = validateStringParam(request, "ddn");
		if (nome == null || cognome == null) {
			request.getRequestDispatcher("BackToAutoriServlet").forward(request,response);
			return;
		}
		
		Long idAut = validateID(request, "idAut");
		if (idAut < 0) {
			request.getRequestDispatcher("BackToLibriServlet").forward(request,response);
			return;
		}
		
		Set<Libro> libri = null;
		try {
			libri =  MyServiceFactory.getAutoreServiceInstance().carica(idAut).getLibri();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Autore autore = new Autore(idAut, nome, cognome, libri);
				
		try {
			AutoreService service =  MyServiceFactory.getAutoreServiceInstance();
			service.aggiorna(autore);
			request.setAttribute("listaAutori", service.elenca());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//andiamo ai risultati
		request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
	}
}
