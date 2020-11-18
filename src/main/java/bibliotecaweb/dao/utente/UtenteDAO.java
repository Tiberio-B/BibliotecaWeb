package bibliotecaweb.dao.utente;

import java.util.List;

import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;

public interface UtenteDAO extends IBaseDAO<Utente> {

	List<Utente> find(String username, String password, Stato stato) throws Exception;
}
