package bibliotecaweb.service.libro;

import java.util.List;

import javax.persistence.EntityManager;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.dao.libro.LibroDAO;
import bibliotecaweb.dao.utente.UtenteDAO;
import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.GenericServiceImpl;
import bibliotecaweb.service.MyServiceFactory;

public class LibroServiceImpl extends GenericServiceImpl<Libro> implements LibroService {

	@Override
	public boolean aggiungi(Libro libro, Autore autore) throws Exception {
		boolean ret = false;
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			IBaseDAO<Libro> dao = getDAO();
			dao.setEntityManager(entityManager);
			
			libro = entityManager.merge(libro);
			autore = entityManager.merge(autore);
			
			if (libro.getAutore() != null) {
				ret = false;
			} else {
				libro.setAutore(autore);
				autore.getLibri().add(libro);
				ret = true;
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		return ret;
	}
	
	@Override
	public List<Libro> cerca(Libro instance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			LibroDAO dao = (LibroDAO) getDAO();
			dao.setEntityManager(entityManager);
			return dao.find(instance);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public List<Libro> cerca(String titolo, String trama, Libro.Genere genere, Long idAutore) throws Exception {
		Autore autore = null;
		if (idAutore != null) { // se è stato specificato un autore
			autore = MyServiceFactory.getAutoreServiceInstance().carica(idAutore); // ottieni l'autore dal database
		} 
		Libro instance = new Libro(titolo, trama, genere, autore); // istanza temporanea per la ricerca
		return MyServiceFactory.getLibroServiceInstance().cerca(instance); // effettua la ricerca sul database
	}
	
//	@Override
//	public List<Libro> cerca(Long idAutore) throws Exception {		
//		Autore autore = MyServiceFactory.getAutoreServiceInstance().carica(idAutore); // ottiene l'autore specificato da idAutore
//		Libro libro = new Libro(); // genera un libro-esempio per l'autore
//		libro.setAutore(autore);	
//		List<Libro> libri = cerca(libro); // ottiene tutti i libri dell'autore
//		return libri;
//	}
}
