package bibliotecaweb.service.libro;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.GenericService;

public interface LibroService extends GenericService<Libro> {

	boolean aggiungi(Libro libro, Autore autore) throws Exception;

}
