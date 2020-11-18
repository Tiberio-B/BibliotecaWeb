package bibliotecaweb.service.utente;

import java.util.List;

import javax.persistence.EntityManager;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.dao.utente.UtenteDAO;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.GenericServiceImpl;

public class UtenteServiceImpl extends GenericServiceImpl<Utente> implements UtenteService {

	@Override
	public boolean aggiungi(Utente utente, Ruolo ruolo) throws Exception {
		boolean ret = false;
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			IBaseDAO<Utente> dao = getDAO();
			dao.setEntityManager(entityManager);
			
			utente = entityManager.merge(utente);
			ruolo = entityManager.merge(ruolo);
			
			ret = utente.getRuoli().add(ruolo);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		return ret;
	}

	@Override
	public List<Utente> trovaDa(Utente instance) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente trova(String username, String password, Utente.Stato stato) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			UtenteDAO dao = (UtenteDAO) getDAO();
			dao.setEntityManager(entityManager);
			List<Utente> ret = dao.find(username, password, stato);
			if (ret.isEmpty()) { return null; }
			else { return ret.get(0); }
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
}
