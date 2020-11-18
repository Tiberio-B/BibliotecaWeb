package bibliotecaweb.dao.utente;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;

import bibliotecaweb.dao.GenericDAOImpl;
import bibliotecaweb.model.Utente;

public class UtenteDAOImpl extends GenericDAOImpl<Utente> implements UtenteDAO {

	@Override
	public Class<Utente> getTClass() {
		return Utente.class;
	}

	@Override
	public String getTName() {
		return "Utente";
	}
	
	@Override
	public List<Utente> find(String username, String password, Utente.Stato stato) {
		Utente utente = new Utente(username, password, stato);
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		List<Utente> results = session.createCriteria(Utente.class).add(Example.create(utente)).list();
		return results;
	}

}
