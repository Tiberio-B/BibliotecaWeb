package bibliotecaweb.dao.autore;

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

}
