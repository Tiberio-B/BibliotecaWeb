package bibliotecaweb.web.servlet.autore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/PrepareDeleteAutoreServlet")
public class PrepareDeleteAutoreServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public PrepareDeleteAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		// ottiene la autore da idAut
		Autore autore = null;
		try {
			autore = MyServiceFactory.getAutoreServiceInstance().carica(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("autoreAttr", autore);
		request.setAttribute("listaAutori", request.getParameter("listaAutori"));

		//andiamo ai risultati
		request.getRequestDispatcher("jsp/autore/delete-autore.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
