package bibliotecaweb.dao.utente;

import java.util.List;

import javax.persistence.TypedQuery;

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
		TypedQuery<Utente> query = entityManager.createQuery("from Utente u where u.username=:username and u.password=:password and u.stato=:stato", Utente.class);
	    query.setParameter("username", username).setParameter("password", password).setParameter("stato", stato);
	    return query.getResultList();
	}

}
