package bibliotecaweb.dao.utente;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import bibliotecaweb.dao.GenericDAOImpl;
import bibliotecaweb.model.Ruolo;
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

	@Override
	public List<Utente> find(Utente instance) {
		String base = "from Utente u ";
		Set<Ruolo> ruoli = instance.getRuoli();
		boolean ruoliNotNull = ruoli != null && !ruoli.isEmpty();
		if (ruoliNotNull) {
			base += "join fetch Ruolo r ";
		}
		base += "where 1=1";
		Long id = instance.getId();
		String nome = instance.getNome();
		String cognome = instance.getCognome();
		String username = instance.getUsername();
		Utente.Stato stato = instance.getStato();
		boolean idNotNull = id != null;
		boolean nomeNotNull = nome != null;
		boolean cognomeNotNull = cognome != null;
		boolean usernameNotNull = username != null;
		boolean statoNotNull = stato != null;
		if (idNotNull) {
			base += "and u.id = :id ";
		}
		if (nomeNotNull) {
			base += "and u.nome = :nome ";
		}
		if (cognomeNotNull) {
			base += "and u.cognome = :cognome ";
		}
		if (usernameNotNull) {
			base += "and u.username = :username ";
		}
		if (statoNotNull) {
			base += "and u.stato = :stato ";
		}
		if (ruoliNotNull) {
			for (Ruolo ruolo : ruoli) {
				base += "and r.id = :ruoloId ";
			}
		}
		TypedQuery<Utente> query = entityManager.createQuery(base, Utente.class);
		if (idNotNull) {
			query.setParameter("id", id);
		}
		if (nomeNotNull) {
			query.setParameter("nome", nome);
		}
		if (cognomeNotNull) {
			query.setParameter("cognome", cognome);
		}
		if (usernameNotNull) {
			query.setParameter("username", username);
		}
		if (ruoliNotNull) {
			for (Ruolo ruolo : ruoli) {
				query.setParameter("ruoloId", ruolo.getId());
			}
		}
	    return query.getResultList();
	}

}
