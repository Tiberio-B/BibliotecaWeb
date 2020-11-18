package bibliotecaweb.web.servlet.autore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/ConfirmUpdateAutoreServlet")
public class ConfirmUpdateAutoreServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmUpdateAutoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ids = request.getParameter("validId");
		Long idOld = Long.parseLong(ids);
		
		// conserva l'autore in autoreOld prima della modifica
		try {
			Autore autoreOld = MyServiceFactory.getAutoreServiceInstance().carica(idOld);
			request.setAttribute("autoreOld", autoreOld);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// request.setAttribute("autoreNew", new Autore(idOld, nome));

		request.getRequestDispatcher("jsp/autore/confirm-update-autore.jsp").forward(request, response);
	}
}
