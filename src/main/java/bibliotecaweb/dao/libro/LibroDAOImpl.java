package bibliotecaweb.dao.libro;

import java.util.List;

import javax.persistence.TypedQuery;

import bibliotecaweb.dao.GenericDAOImpl;
import bibliotecaweb.model.Libro;

public class LibroDAOImpl extends GenericDAOImpl<Libro> implements LibroDAO {

	@Override
	public Class<Libro> getTClass() {
		return Libro.class;
	}

	@Override
	public String getTName() {
		return "Libro";
	}

	@Override
	public List<Libro> find(Libro instance) {
		String base = "from Libro l where 1=1 ";
		Long id = instance.getId();
		String titolo = instance.getTitolo();
		String trama = instance.getTrama();
		Libro.Genere genere = instance.getGenere();
		boolean idNotNull = id != null;
		boolean titoloNotNull = titolo != null;
		boolean tramaNotNull = trama != null;
		boolean genereNotNull = genere != null;
		if (idNotNull) {
			base += "and l.id = :id";
		}
		if (titoloNotNull) {
			base += "and l.titolo like :titolo ";
		}
		if (tramaNotNull) {
			base += "and l.trama like :trama ";
		}
		if (genereNotNull) {
			base += "and l.genere = :genere ";
		}
		TypedQuery<Libro> query = entityManager.createQuery(base, Libro.class);
		if (idNotNull) {
			query.setParameter("id", id);
		}
		if (titoloNotNull) {
			query.setParameter("titolo", "%"+titolo+"%");
		}
		if (tramaNotNull) {
			query.setParameter("trama", "%"+trama+"%");
		}
		if (genereNotNull) {
			query.setParameter("genere", genere);
		}
	    return query.getResultList();
	}

}
