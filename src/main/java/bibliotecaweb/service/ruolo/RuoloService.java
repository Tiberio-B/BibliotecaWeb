package bibliotecaweb.service.ruolo;

import java.util.Set;

import bibliotecaweb.model.Ruolo;
import bibliotecaweb.service.GenericService;

public interface RuoloService extends GenericService<Ruolo> {
	
	public Set<Ruolo> carica(String[] ruoliIdInput) throws Exception;
}
