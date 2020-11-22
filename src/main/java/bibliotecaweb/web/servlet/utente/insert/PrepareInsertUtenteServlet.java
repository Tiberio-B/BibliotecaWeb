package bibliotecaweb.web.servlet.utente.insert;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet("/PrepareInsertUtenteServlet")
public class PrepareInsertUtenteServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;

	public PrepareInsertUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		initUtenteAttributes(request);
		request.getRequestDispatcher("jsp/utente/insert-utente.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}