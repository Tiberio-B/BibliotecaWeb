package bibliotecaweb.service.utente;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;
import bibliotecaweb.service.GenericService;

public interface UtenteService extends GenericService<Utente> {

	boolean aggiungi(Utente utente, Ruolo ruolo) throws Exception;

	Utente trova(String username, String password, Stato stato) throws Exception;

}
