package bibliotecaweb.dao.ruolo;

import java.util.List;

import bibliotecaweb.dao.GenericDAOImpl;
import bibliotecaweb.model.Ruolo;

public class RuoloDAOImpl extends GenericDAOImpl<Ruolo> implements RuoloDAO {

	@Override
	public Class<Ruolo> getTClass() {
		return Ruolo.class;
	}

	@Override
	public String getTName() {
		return "Ruolo";
	}

	@Override
	public List<Ruolo> find(Ruolo instance) {
		// TODO Auto-generated method stub
		return null;
	}

}
