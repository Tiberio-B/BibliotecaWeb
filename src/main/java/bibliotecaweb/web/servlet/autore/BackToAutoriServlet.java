package bibliotecaweb.web.servlet.autore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet(urlPatterns = {"/BackToAutoriServlet", "/ListAutoriServlet"})
public class BackToAutoriServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;
       
    public BackToAutoriServlet() {
        super();
    }
    
    protected void doSame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Autore> autori = null;
		try {
			autori = MyServiceFactory.getAutoreServiceInstance().elenca();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere agli autori presenti in biblioteca");
			request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
			return;
		}
		request.setAttribute("autori", autori);
		request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doSame(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doSame(request, response);
	}

}
