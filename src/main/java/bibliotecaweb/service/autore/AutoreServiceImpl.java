package bibliotecaweb.service.autore;

import java.util.List;

import javax.persistence.EntityManager;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.model.Autore;
import bibliotecaweb.service.GenericServiceImpl;

public class AutoreServiceImpl extends GenericServiceImpl<Autore> implements AutoreService {

	@Override
	public List<Autore> trovaDa(Autore instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rimuovi(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			IBaseDAO<Autore> dao = getDAO();
			dao.setEntityManager(entityManager);
			Autore instance = dao.get(id);
			dao.delete(instance);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

}
