package bibliotecaweb.service.libro;

import java.util.List;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Libro.Genere;
import bibliotecaweb.service.GenericService;

public interface LibroService extends GenericService<Libro> {

	boolean aggiungi(Libro libro, Autore autore) throws Exception;

	List<Libro> cerca(String titolo, String trama, Genere genere, Long idAutore) throws Exception;

}
