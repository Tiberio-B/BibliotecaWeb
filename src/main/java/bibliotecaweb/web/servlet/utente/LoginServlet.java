package bibliotecaweb.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// String path = request.getContextPath();
		
		// se l'utente e' gia' loggato, torna in homepage
		if(request.getSession().getAttribute("utente") != null ) {
			request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getContextPath();
		
		boolean addError = true; // campi null in login costituiscono errore
		
		// i parametri vuoti/invalidi vengono valorizzati a null
		String username = validateStringParam(request, "username", addError );
		String password = validateStringParam(request, "password", addError );
		
		// se la validazione fallisce torno in pagina
		if (username.isEmpty() || password.isEmpty()) {
			addError(request, "Inserire username e password per effettuare l'accesso");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		Utente utente = null;
		try {
			utente = MyServiceFactory.getUtenteServiceInstance().cerca(username, password, Utente.Stato.ATTIVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (utente == null) {
			addError(request, "L'username o la password sono errati");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		HttpSession sess = request.getSession(true);
		sess.setAttribute("utente", utente);
		sess.setAttribute("cannotInsert", !(utente.isClassic() || utente.isAdmin()));
		sess.setAttribute("cannotUpdate", !(utente.isClassic() || utente.isAdmin()));
		sess.setAttribute("cannotDelete", !(utente.isAdmin()));
		
		request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
	}
}
