package bibliotecaweb.service.utente;

import java.util.List;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;
import bibliotecaweb.service.GenericService;

public interface UtenteService extends GenericService<Utente> {

	boolean aggiungi(Utente utente, Ruolo ruolo) throws Exception;

	Utente trova(String username, String password, Stato stato) throws Exception;

	List<Utente> cerca(String nomeInput, String cognomeInput, String usernameInput,
			String statoInput, String[] ruoliIdInput) throws Exception;

}
