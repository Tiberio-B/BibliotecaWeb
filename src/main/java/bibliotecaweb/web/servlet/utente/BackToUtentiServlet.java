package bibliotecaweb.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/BackToUtentiServlet")
public class BackToUtentiServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;
       
    public BackToUtentiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		updateUtentiInSession(request);
		request.getRequestDispatcher("jsp/utente/utenti.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		updateUtentiInSession(request);
		request.getRequestDispatcher("jsp/utente/utenti.jsp").forward(request, response);
	}

}
