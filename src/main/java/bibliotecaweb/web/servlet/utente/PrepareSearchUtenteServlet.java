package bibliotecaweb.web.servlet.utente;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareSearchUtenteServlet
 */
@WebServlet("/PrepareSearchUtenteServlet")
public class PrepareSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareSearchUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente.Stato[] stati = Utente.Stato.values();
		request.setAttribute("stati", stati);
		Ruolo.Codice[] ruoli = Ruolo.Codice.values();
		request.setAttribute("ruoli", ruoli);
		
		request.getRequestDispatcher("jsp/utente/search-utente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
