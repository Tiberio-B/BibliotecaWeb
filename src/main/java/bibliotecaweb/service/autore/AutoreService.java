package bibliotecaweb.service.autore;

import bibliotecaweb.model.Autore;
import bibliotecaweb.service.GenericService;

public interface AutoreService extends GenericService<Autore> {
	
	public void rimuovi(Long id) throws Exception;

}
