package bibliotecaweb.web.servlet.autore.search;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/ExecuteSearchAutoreServlet")
public class ExecuteSearchAutoreServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteSearchAutoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean addError = false; // parametri null in ricerca non costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		String nome = validateStringParam(request, "nome", addError);
		String cognome = validateStringParam(request, "cognome", addError);
		Date ddn = validateDateParam(request, "ddn", addError);
		
		List<Autore> autori = null; // risultati della ricerca
		try {
			autori = MyServiceFactory.getAutoreServiceInstance().cerca(new Autore(nome, cognome, ddn)); // effettua la ricerca sul database
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "La ricerca ha riscontrato problemi.");
			request.getRequestDispatcher("jsp/autore/search-autore.jsp").forward(request, response);
			return;
		}
		
		if (autori.isEmpty()) {
			addError(request, "Nessun autore presente nella biblioteca soddisfa i parameri di ricerca specificati.");
			request.getRequestDispatcher("jsp/libro/search-libro.jsp").forward(request, response);
		}
		
		request.setAttribute("autori", autori);
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
	}
}
