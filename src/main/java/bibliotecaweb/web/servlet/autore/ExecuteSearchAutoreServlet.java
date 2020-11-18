package bibliotecaweb.web.servlet.autore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;

@WebServlet("/ExecuteSearchAutoreServlet")
public class ExecuteSearchAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExecuteSearchAutoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		Autore autore = new Autore(nome, cognome);
		List<Autore> autori = null;
		try {
			autori = MyServiceFactory.getAutoreServiceInstance().cerca(autore);
			request.setAttribute("listaAutori", autori);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("searched", true);
		request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
	}
}
