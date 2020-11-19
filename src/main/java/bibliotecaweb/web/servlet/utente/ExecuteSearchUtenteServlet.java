package bibliotecaweb.web.servlet.utente;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Ruolo.Codice;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/ExecuteSearchUtenteServlet")
public class ExecuteSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteSearchUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cognomeInput = request.getParameter("cognome");
		String nomeInput = request.getParameter("nome");	
		String usernameInput = request.getParameter("username");
		String statoInput = request.getParameter("stato");
		String[] ruoliIdInput = request.getParameterValues("ruoliId");
		List<Utente> utenti = null;
		try {
			utenti = MyServiceFactory
					.getUtenteServiceInstance()
					.cerca(nomeInput, cognomeInput, usernameInput, statoInput, ruoliIdInput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("listaUtenti", utenti);
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/utente/utenti.jsp").forward(request, response);
	}

}
