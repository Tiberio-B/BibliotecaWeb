package bibliotecaweb.service.ruolo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.service.GenericServiceImpl;
import bibliotecaweb.service.MyServiceFactory;

public class RuoloServiceImpl extends GenericServiceImpl<Ruolo> implements RuoloService {

	@Override
	public Set<Ruolo> carica(String[] ruoliIdInput) throws Exception {
		Long[] ids = null;
		if (ruoliIdInput != null) {
			int numRuoli = ruoliIdInput.length;
			if (numRuoli > 0) {
				ids = new Long[numRuoli];
				for (int i=0; i < numRuoli; i++) {
					ids[i] = Long.parseLong(ruoliIdInput[i]);
				}
			}
		}
		Set<Ruolo> ruoli = new HashSet<>();
		if (ids != null) {
			for (Long id : ids) {
				ruoli.add(carica(id));
			}
		}
		return ruoli;
	}

}