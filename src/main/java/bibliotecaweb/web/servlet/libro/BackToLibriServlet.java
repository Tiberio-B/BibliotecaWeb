package bibliotecaweb.web.servlet.libro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.model.Libro;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.web.servlet.AbstractUtilityServlet;

@WebServlet(urlPatterns = {"/BackToLibriServlet", "/ListLibriServlet"})
public class BackToLibriServlet extends AbstractUtilityServlet {
	private static final long serialVersionUID = 1L;
       
    public BackToLibriServlet() {
        super();
    }

    protected void doSame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Libro> libri = null;
		try {
			libri = MyServiceFactory.getLibroServiceInstance().elenca();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere ai libri presenti in biblioteca");
			request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
			return;
		}
		request.setAttribute("libri", libri);
		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doSame(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doSame(request, response);
	}

}
