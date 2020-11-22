package bibliotecaweb.service.utente;

import java.util.List;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;
import bibliotecaweb.service.GenericService;

public interface UtenteService extends GenericService<Utente> {

	boolean aggiungi(Utente utente, Ruolo ruolo) throws Exception;

	Utente cerca(String username, String password, Stato stato) throws Exception;
	
	List<Utente> cerca(String nome, String cognome, String username, Stato stato,
			String[] ruoliIdInput) throws Exception;

	boolean rimozioneLogica(Long idUt) throws Exception;

}
