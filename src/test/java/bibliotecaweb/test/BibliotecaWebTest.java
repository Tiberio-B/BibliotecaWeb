package bibliotecaweb.test;

import java.util.ArrayList;
import java.util.List;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Ruolo.Codice;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;
import bibliotecaweb.service.autore.AutoreService;
import bibliotecaweb.service.libro.LibroService;
import bibliotecaweb.service.ruolo.RuoloService;
import bibliotecaweb.service.utente.UtenteService;
import bibliotecaweb.test.casuale.GeneratoreCasuale;

public class BibliotecaWebTest {
	
	private static final LibroService libroService = MyServiceFactory
			.getLibroServiceInstance();
	private static final UtenteService utenteService = MyServiceFactory
			.getUtenteServiceInstance();
	private static final AutoreService autoreService = MyServiceFactory
			.getAutoreServiceInstance();
	private static final RuoloService ruoloService = MyServiceFactory
			.getRuoloServiceInstance();

	private static final GeneratoreCasuale r = new GeneratoreCasuale();
	
	private static List<Libro> libri;
	private static List<Utente> utenti;
	private static List<Autore> autori;
	private static List<Ruolo> ruoli;

	private static final int numAutori = 10;
	private static final int numLibri = 30;
	private static final int numUtenti = 8;
	private static final int numAssegnazioniRuoli = 15;
	private static final int numScrittureLibri = 20;
	
	public static void stampa(Object obj) {
		System.out.println(obj);
	}
	
	public static void init(int numLibri, int numUtenti, int numAutori) throws Exception {
		initLibri(numLibri);
		initUtenti(numUtenti);
		initAutori(numAutori);
	}
	
	public static void initRuoli() throws Exception {
			Ruolo ruolo1 = new Ruolo(Codice.ADMIN_ROLE, "amministratore");
			Ruolo ruolo2 = new Ruolo(Codice.GUEST_ROLE, "guest");
			Ruolo ruolo3 = new Ruolo(Codice.CLASSIC_ROLE, "classic");
			ruoloService.inserisci(ruolo1);
			ruoloService.inserisci(ruolo2);
			ruoloService.inserisci(ruolo3);
			ruoli = ruoloService.elenca();
	}

	public static void initLibri(int numLibri) throws Exception {
		for (int l = 0; l < numLibri; l++) {
			Libro lib = new Libro(r.cvcvcv(), r.genereCasuale(), "trama");
			libroService.inserisci(lib);
			System.out.println("Libro appena creato: " + lib);
		}
		libri = libroService.elenca();
	}
	
	public static void initUtenti(int numUtenti) throws Exception {
		for (int u = 0; u < numUtenti; u++) {
			Utente ut = new Utente(r.nomeCasuale(), r.cognomeCasuale(), r.cvcvcv());
			utenteService.inserisci(ut);
			System.out.println("Utente appena creato: " + ut);
		}
		utenti = utenteService.elenca();
	}
	
	public static void initAutori(int numAutori) throws Exception {
		for (int a = 0; a < numAutori; a++) {
			Autore aut = new Autore(r.nomeCasuale(), r.cognomeCasuale(), r.ddnCasuale());
			autoreService.inserisci(aut);
			System.out.println("Autore appena creato: " + aut);
		}
		autori = autoreService.elenca();
	}
	
	public static void doAssegnazioniRuoli(int numAssegnazioniRuoli) throws Exception {
		for (int j = 0; j < numAssegnazioniRuoli; j++) {
			Utente utente = r.utenteCasuale();
			Ruolo ruolo = r.ruoloCasuale();
			utente.addRuolo(ruolo);
		}
	}
	
	public static void doScrittureLibri(int numScrittureLibri) throws Exception{
		for (int k = 0; k < numScrittureLibri; k++) {
			Libro libro = r.libroCasuale();
			Autore autore = r.autoreCasuale();
			libro.addAutore(autore);
		}
	}
	
	public static void authentication(String username, String password) throws Exception {
		Utente utente = new Utente(username, password, Utente.Stato.NON_ATTIVO);
		String uUsername = utente.getUsername();
		String uPassword = utente.getPassword();
		Utente.Stato uStato = utente.getStato();
		System.out.println(MyServiceFactory.getUtenteServiceInstance().trova(uUsername, uPassword, uStato));
	}
	
	public static void feedback() {
		try {
			libri = libroService.elenca();
			utenti = utenteService.elenca();
			autori = autoreService.elenca();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Object> all = new ArrayList<>();
		all.addAll(libri);
		all.addAll(utenti);
		all.addAll(autori);
		for (Object obj : all) {
			System.out.println(obj);
		}
	}
	
	public static void main(String[] args) {
		
		try {
		
			init(numLibri, numUtenti, numAutori); // inizializza tutte le tabelle
			
			initRuoli();
			
			doScrittureLibri(numScrittureLibri); // collega Autori e Libri
			
			doAssegnazioniRuoli(numAssegnazioniRuoli); // collega Utenti e Ruoli
			
			// authentication("Ususalu", "password");
			
			// feedback(); // stampa a schermo tutti i recuts nel DB
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}
}
