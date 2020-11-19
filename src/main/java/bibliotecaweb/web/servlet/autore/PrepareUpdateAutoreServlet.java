package bibliotecaweb.web.servlet.autore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/PrepareUpdateAutoreServlet")
public class PrepareUpdateAutoreServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public PrepareUpdateAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idOld = validateID(request, "idAut");
		if (idOld < 0) {
			request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
		}
		// ottiene la autore da idOld
		Autore autoreOld = null;
		try {
			autoreOld = MyServiceFactory.getAutoreServiceInstance().carica(idOld);
			request.setAttribute("autoreOld", autoreOld);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("jsp/autore/update-autore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
