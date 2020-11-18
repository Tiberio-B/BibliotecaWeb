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
		String base = "SELECT DISTINCT u FROM Utente u ";
		Set<Ruolo> ruoli = instance.getRuoli();
		boolean ruoliNotNull = ruoli != null && !ruoli.isEmpty();
		if (ruoliNotNull) {
			base += "JOIN u.ruoli r ";
		}
		base += "WHERE 1=1 ";
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
			base += "AND u.id = :id ";
		}
		if (nomeNotNull) {
			base += "AND u.nome = :nome ";
		}
		if (cognomeNotNull) {
			base += "AND u.cognome = :cognome ";
		}
		if (usernameNotNull) {
			base += "AND u.username = :username ";
		}
		if (statoNotNull) {
			base += "AND u.stato = :stato ";
		}
		if (ruoliNotNull) {
			for (int i=0; i < ruoli.size(); i++) {
				base += "AND ?";
				base+= String.valueOf(1+i);
				base += " MEMBER OF u.ruoli ";
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
		if (statoNotNull) {
			query.setParameter("stato", stato);
		}
		if (ruoliNotNull) {
			for (int i=0; i < ruoli.size(); i++) {
				query.setParameter(1+i, ruoli.iterator().next());
			}
		}
	    return query.getResultList();
	}

}
