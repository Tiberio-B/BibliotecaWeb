package bibliotecaweb.service.libro;

import java.util.List;

import javax.persistence.EntityManager;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.service.GenericServiceImpl;

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
	public List<Libro> trovaDa(Libro instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
