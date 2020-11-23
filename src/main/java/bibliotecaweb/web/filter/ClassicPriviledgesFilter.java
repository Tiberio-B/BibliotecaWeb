package bibliotecaweb.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import bibliotecaweb.model.Utente;

/**
 * Servlet Filter implementation class VerifyLoginFilter
 */
@WebFilter(urlPatterns = {"/blabla"})
public class ClassicPriviledgesFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClassicPriviledgesFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getContextPath();
		Utente utente = (Utente) req.getSession().getAttribute("utente");
		
		// se l'utente non e' loggato, torna alla login
		if(utente == null ) {
			req.setAttribute("errorMessage", "Devi aver effettuato l'accesso per visualizzare questa pagina.");
			req.getRequestDispatcher(path + "/index.jsp").forward(req, response);
			return;
		}
		
		// se l'utente non e' amministratore, torna alla login
		if(!utente.isAdmin()) {
			req.setAttribute("errorMessage", "Devi aver effettuato l'accesso come Amministratore per visualizzare questa pagina.");
			req.getRequestDispatcher(path + "/index.jsp").forward(req, response);
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
