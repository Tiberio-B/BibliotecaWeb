package bibliotecaweb.dao.autore;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import bibliotecaweb.dao.GenericDAOImpl;
import bibliotecaweb.model.Autore;

public class AutoreDAOImpl extends GenericDAOImpl<Autore> implements AutoreDAO {

	@Override
	public Class<Autore> getTClass() {
		return Autore.class;
	}

	@Override
	public String getTName() {
		return "Autore";
	}

	@Override
	public List<Autore> find(Autore instance) {
		String base = "from Autore a where 1=1 ";
		Long id = instance.getId();
		String nome = instance.getNome();
		String cognome = instance.getCognome();
		Date ddn = instance.getDdn();
		boolean idNotNull = id != null;
		boolean nomeNotNull = nome != null;
		boolean cognomeNotNull = cognome != null;
		boolean ddnNotNull = ddn != null;
		if (idNotNull) {
			base += "and a.id = :id ";
		}
		if (nomeNotNull) {
			base += "and a.nome like :nome ";
		}
		if (cognomeNotNull) {
			base += "and a.cognome like :cognome ";
		}
		if (ddnNotNull) {
			base += "and a.ddn = :ddn ";
		}
		TypedQuery<Autore> query = entityManager.createQuery(base, Autore.class);
		if (idNotNull) {
			query.setParameter("id", id);
		}
		if (nomeNotNull) {
			query.setParameter("nome", "%"+nome+"%");
		}
		if (cognomeNotNull) {
			query.setParameter("cognome", "%"+cognome+"%");
		}
		if (ddnNotNull) {
			query.setParameter("ddn", ddn);
		}
	    return query.getResultList();
	}

}
