package bibliotecaweb.web.servlet.utente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Ruolo.Codice;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Libro.Genere;
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
		String cognome = cognomeInput.isEmpty() ? null : cognomeInput;
		String nomeInput = request.getParameter("nome");
		String nome = nomeInput.isEmpty() ? null : nomeInput;
		String usernameInput = request.getParameter("username");
		String username = usernameInput.isEmpty() ? null : usernameInput;
		String statoInput = request.getParameter("stato");
		Utente.Stato stato = statoInput.isEmpty() ? null : Stato.valueOf(statoInput);
		String ruoloInput = request.getParameter("ruolo");
		Ruolo.Codice codiceRuolo = ruoloInput.isEmpty() ? null : Codice.valueOf(ruoloInput);
		
		Ruolo ruolo = new Ruolo(codiceRuolo);
		Utente utente = new Utente(nome, cognome, username, stato, ruolo);
		
		List<Utente> utenti = null;
		try {
			utenti = MyServiceFactory.getUtenteServiceInstance().cerca(utente);
			request.setAttribute("listaUtenti", utenti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/utente/utenti.jsp").forward(request, response);
	}

}
