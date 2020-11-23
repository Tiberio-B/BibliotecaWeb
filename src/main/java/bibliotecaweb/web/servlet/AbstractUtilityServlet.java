package bibliotecaweb.web.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;

public abstract class AbstractUtilityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	   * Metodo per la validazione di un parametro di nome {@code stringParamName}
	   * dell'oggetto richiesta {@code HttpServletRequest request}.
	   * Se il valore del parametro è una sequenza di caratteri valida
	   * (stringa non vuota e non null), viene ritornata senza modifiche;
	   * altrimenti viene ritornato {@code null} e il parametro {@code errorMessage}
	   * della {@code request} è aggiornato con un messaggio di errore opportuno.
	   * 
	   * @param request la richiesta da cui ottenere il parametro
	   * @param stringParamName il nome del parametro da ottenere dalla richiesta
	   * @return String il valore del parametro se è una stringa non vuota e non null;
	   * @return null altrimenti.
	   * 
	   * @see HttpServletRequest
	   */
	public static String validateStringParam(HttpServletRequest request, String stringParamName, boolean addError) {
		String param = request.getParameter(stringParamName);
		if (param == null || param.isEmpty()) { // se stringa invalida, aggiorna messaggio di errore
			if (addError) { 
				addError(request, "Il campo '"+ stringParamName +"' deve essere una sequenza di caratteri validi.");
			}
			return null;
		}
		return param;
	}
	
	/**
	   * Metodo per la validazione di un parametro di nome {@code enumParamName}
	   * dell'oggetto richiesta {@code HttpServletRequest request}.
	   * Se il valore del parametro è una sequenza di caratteri valida
	   * (stringa non vuota e non null), viene tentata la conversione dello stesso
	   * all'istanza corrispondente del tipo enumerativo specificato da {@code enumType},
	   * ritornata poi in output;
	   * altrimenti viene ritornato {@code null} e il parametro {@code errorMessage}
	   * della {@code request} è aggiornato con un messaggio di errore opportuno.
	   * 
	   * @param request la richiesta da cui ottenere il parametro
	   * @param enumParamName il nome del parametro da ottenere dalla richiesta
	   * @param enumType il tipo enumerativo a cui il parametro deve essere convertito
	   * @return istanza di tipo {@code enumType} corrispondente al parametro, se valido;
	   * @return null altrimenti.
	   * 
	   * @see HttpServletRequest
	   */
	public static <T extends Enum<T>> T validateEnumParam(HttpServletRequest request, String enumParamName, Class<T> enumType, boolean addError) {
		String enumParam = validateStringParam(request, enumParamName, false);
		T enumVar = null;
		try {
			enumVar = Enum.valueOf(enumType, enumParam);
		} catch (NullPointerException | IllegalArgumentException e) {
			if (addError) { 
				addError(request, enumType.getSimpleName() + " specificato non presente nella biblioteca.");
			}
			return null;
		}
		return enumVar;		
	}
	
	/**
	   * Metodo per la validazione di un parametro di nome {@code longParamName}
	   * dell'oggetto richiesta {@code HttpServletRequest request}.
	   * Se il valore del parametro è parsabile in un oggetto di tipo {@code Long},
	   * viene ritornato come tale; altrimenti viene ritornato {@code null}
	   * e il parametro {@code errorMessage} della {@code request} è aggiornato
	   * con un messaggio di errore opportuno.
	   * 
	   * @param request la richiesta da cui ottenere il parametro
	   * @param longParamName il nome del parametro da ottenere dalla richiesta
	   * @return Long il valore del parametro se è parsabile in un qualsiasi numero {@code Long}
	   * @return {@code null} altrimenti.
	   * 
	   * @see HttpServletRequest
	   */
	public static Long validateLongParam(HttpServletRequest request, String longParamName, boolean addError) {
		Long id = null;
		try {
			String param = request.getParameter(longParamName);
			id = Long.parseLong(param);
		} catch (NumberFormatException | NullPointerException e) { // se ID invalido, aggiorna messaggio di errore
			if (addError) { 
				addError(request, "Il campo '"+ longParamName +"' deve essere un intero valido.");
			}
			return null;
		}
		return id;
	}
	
	public static Date validateDateParam(HttpServletRequest request, String dateParamName, boolean addError) {
		Date date = null;
		try {
			System.out.println(request.getParameter(dateParamName));
			String[] stringParams = request.getParameter(dateParamName).split("-");
			Integer[] params = new Integer[3];
			for (int i = 0; i < 3; i++) {
				params[i] = Integer.valueOf(stringParams[i]);
				System.out.println(stringParams[i] +"\n"+ params[i]);
			}
			date = new Date(params[2], params[1] - 1, params[0]);
		} catch (IllegalArgumentException | NullPointerException e) {
			if (addError) { 
				addError(request, "Il campo '"+ dateParamName +"' deve essere una data espressa nel formato gg-mm-aaaa.");
			}
			return null;
		}
		return date;	
	}
	
	/**
	   * Metodo per la validazione di un parametro di nome {@code utenteParamName}
	   * dell'oggetto richiesta {@code HttpServletRequest request}.
	   * Se il valore del parametro corrisponde ad un oggetto di tipo {@code Utente}
	   * il cui valore ruolo {@code Utente.Ruolo} è autorizzato (presente all'interno
	   * dell'array {@code ruoliAutorizzati}), viene ritornato {@code 1};
	   * altrimenti viene ritornato {@code -1} (parametro = {@code null}) oppure
	   * {@code 0} e il parametro {@code errorMessage} della {@code request} è
	   * aggiornato con un messaggio di errore opportuno,
	   * ed eventualmente i ruoli autorizzati.
	   * 
	   * @param request la richiesta da cui ottenere il parametro
	   * @param utenteParamName il nome del parametro da ottenere dalla richiesta
	   * @param ruoliAutorizzati l'insieme dei ruoli autorizzati ad accedere alla pagina
	   * @return {@code -1} se il valore del parametro è null
	   * @return {@code 1} se il valore del parametro è un {@code Utente} con campo {@code ruolo} presente in {@code ruoliAutorizzati}
	   * @return {@code 0} altrimenti.
	   * 
	   * @see HttpServletRequest
	   */
	public static int verifyUser(HttpServletRequest request, String utenteParamName, Set<Ruolo> ruoliAutorizzati) {
		Utente utente = (Utente) request.getSession().getAttribute(utenteParamName);
		if (utente == null) {
			addError(request, "Devi essere loggato per effettuare questa operazione.");
			return -1; // se null, ritorna -1
		}
		String ruoliAutorizzatiString = ""; // per la stampa del messaggio di errore
		String ruoliAttualiString = ""; // per la stampa del messaggio di errore
		Set<Ruolo> ruoliUtente = utente.getRuoli();
		for (int j=0; j < ruoliUtente.size(); j++) {
			Ruolo ruoloUtente = ruoliUtente.iterator().next();
			ruoliAttualiString += ruoloUtente.getCodice().name();
			for (int i=0; i < ruoliAutorizzati.size(); i++) { // itera sui ruoli autorizzati
				Ruolo ruoloAutorizzato = ruoliAutorizzati.iterator().next();
				if (ruoloUtente == ruoloAutorizzato) return 1; // se autorizzato, ritorna 1
				ruoliAutorizzatiString += ruoloAutorizzato.getCodice().name();
				if (i < ruoliAutorizzati.size()-1) { // tranne l'ultima iterazione
					ruoliAutorizzatiString += ", ";
				}
			}
			if (j < ruoliUtente.size()-1) { // tranne l'ultima iterazione
				ruoliAttualiString += ", ";
			}
		}
		String errorMessage = "Non possiedi le credenziali necessarie ad effettuare questa operazione.\n"+
							"Ruolo richiesto: " + ruoliAutorizzatiString + " Ruoli attuali: "+ ruoliAttualiString;
		addError(request, errorMessage);
		return 0; // se non autorizzato ritorna 0
	}
	
	public static void updateLibriEAutoriInSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		try {
			session.setAttribute("autori", MyServiceFactory.getAutoreServiceInstance().elenca());
			session.setAttribute("libri", MyServiceFactory.getLibroServiceInstance().elenca());
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("generi", Libro.Genere.values());
	}
	
	public static void updateUtentiInSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		try {
			session.setAttribute("utenti", MyServiceFactory.getUtenteServiceInstance().elenca());
			session.setAttribute("roli", MyServiceFactory.getRuoloServiceInstance().elenca());
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.setAttribute("stati", Utente.Stato.values());
	}
	
	public static void addError(HttpServletRequest request, String errorMessageString) {
		Object attr = request.getAttribute("errorMessages");
		if (attr == null) {
			attr = new ArrayList<String>();
		}
		if (attr instanceof ArrayList<?>) {
			((ArrayList<String>) attr).add(errorMessageString);
		}
		request.setAttribute("errorMessages", attr);
	}
	
	public static void initLibroAttributes(HttpServletRequest request) {
		List<Autore> autori = null;
		try {
			autori = MyServiceFactory.getAutoreServiceInstance().elenca();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere agli autori della biblioteca.");
		}
		request.setAttribute("autori", autori);
		request.setAttribute("generi", Libro.Genere.values());
	}
	
	public static void initAutoreAttributes(HttpServletRequest request, Long idAutore) {
		Set<Libro> libri = null;
		try {
			libri = MyServiceFactory.getAutoreServiceInstance().carica(idAutore).getLibri();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere ai libri dell'autore specificato.");
		}
		request.setAttribute("libri", libri);
	}
	
	public static void initLibri(HttpServletRequest request) {
		List<Libro> libri = null;
		try {
			libri = MyServiceFactory.getLibroServiceInstance().elenca();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere ai libri della biblioteca.");
		}
		request.setAttribute("libri", libri);
	}
	
	public static void initUtenteAttributes(HttpServletRequest request) {
		List<Ruolo> ruoli = null;
		try {
			ruoli = MyServiceFactory.getRuoloServiceInstance().elenca();
		} catch (Exception e) {
			e.printStackTrace();
			addError(request, "Impossibile accedere ai ruoli utente.");
		}
		request.setAttribute("ruoli", ruoli);
		request.setAttribute("stati", Utente.Stato.values());
	}
}

