package bibliotecaweb.dao.libro;

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

}
