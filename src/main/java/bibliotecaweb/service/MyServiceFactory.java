package bibliotecaweb.service;

import bibliotecaweb.dao.MyDAOFactory;
import bibliotecaweb.service.autore.AutoreService;
import bibliotecaweb.service.autore.AutoreServiceImpl;
import bibliotecaweb.service.libro.LibroService;
import bibliotecaweb.service.libro.LibroServiceImpl;
import bibliotecaweb.service.ruolo.RuoloService;
import bibliotecaweb.service.ruolo.RuoloServiceImpl;
import bibliotecaweb.service.utente.UtenteService;
import bibliotecaweb.service.utente.UtenteServiceImpl;

public class MyServiceFactory {

	// rendiamo questo factory SINGLETON
	private static AutoreService AUTORE_SERVICE_INSTANCE;
	private static LibroService LIBRO_SERVICE_INSTANCE;
	private static UtenteService UTENTE_SERVICE_INSTANCE;
	private static RuoloService RUOLO_SERVICE_INSTANCE;

	public static AutoreService getAutoreServiceInstance() {
		if (AUTORE_SERVICE_INSTANCE == null)
			AUTORE_SERVICE_INSTANCE = new AutoreServiceImpl();

		AUTORE_SERVICE_INSTANCE.setDAO(MyDAOFactory.getAutoreDAOInstance());
		return AUTORE_SERVICE_INSTANCE;
	}

	public static LibroService getLibroServiceInstance() {
		if (LIBRO_SERVICE_INSTANCE == null)
			LIBRO_SERVICE_INSTANCE = new LibroServiceImpl();

		LIBRO_SERVICE_INSTANCE.setDAO(MyDAOFactory.getLibroDAOInstance());
		return LIBRO_SERVICE_INSTANCE;
	}
	
	public static UtenteService getUtenteServiceInstance() {
		if (UTENTE_SERVICE_INSTANCE == null)
			UTENTE_SERVICE_INSTANCE = new UtenteServiceImpl();

		UTENTE_SERVICE_INSTANCE.setDAO(MyDAOFactory.getUtenteDAOInstance());
		return UTENTE_SERVICE_INSTANCE;
	}
	
	public static RuoloService getRuoloServiceInstance() {
		if (RUOLO_SERVICE_INSTANCE == null)
			RUOLO_SERVICE_INSTANCE = new RuoloServiceImpl();

		RUOLO_SERVICE_INSTANCE.setDAO(MyDAOFactory.getRuoloDAOInstance());
		return RUOLO_SERVICE_INSTANCE;
	}

}
