package bibliotecaweb.web.servlet.libro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bibliotecaweb.web.servlet.MyAbstractServlet;

@WebServlet("/BackToLibriServlet")
public class BackToLibriServlet extends MyAbstractServlet {
	private static final long serialVersionUID = 1L;
       
    public BackToLibriServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		updateLibriEAutoriInSession(request);
		request.getRequestDispatcher("jsp/libro/libri.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
