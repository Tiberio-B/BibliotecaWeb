package bibliotecaweb.web.servlet.autore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/BackToAutoriServlet")
public class BackToAutoriServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;
       
    public BackToAutoriServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		updateLibriEAutoriInSession(request);
		request.getRequestDispatcher("jsp/autore/autori.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
