package bibliotecaweb.service.utente;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.GenericServiceImpl;
import bibliotecaweb.service.MyServiceFactory;

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
	public Utente cerca(String username, String password, Utente.Stato stato) throws Exception {
		Utente instance = new Utente(username, password, stato);
		List<Utente> ret = cerca(instance);
		if (ret.isEmpty()) { return null; }
		else { return ret.get(0); }
//		EntityManager entityManager = EntityManagerUtil.getEntityManager();
//		try {
//			UtenteDAO dao = (UtenteDAO) getDAO();
//			dao.setEntityManager(entityManager);
//			List<Utente> ret = dao.find(username, password, stato);
//			if (ret.isEmpty()) { return null; }
//			else { return ret.get(0); }
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		} finally {
//			entityManager.close();
//		}
	}

	@Override
	public List<Utente> cerca(String nome, String cognome, String username, Utente.Stato stato, String[] ruoliIdInput) throws Exception {
		Set<Ruolo> ruoli = MyServiceFactory.getRuoloServiceInstance().carica(ruoliIdInput);
		Utente instance = new Utente(nome, cognome, username, stato, ruoli);
		return MyServiceFactory.getUtenteServiceInstance().cerca(instance);
	}

	@Override
	public boolean rimozioneLogica(Long idUt) throws Exception {
		boolean eraAttivo = false;
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			IBaseDAO<Utente> dao = getDAO();
			dao.setEntityManager(entityManager);
			Utente utente = dao.get(idUt);
			eraAttivo = utente.disattiva();
			utente = entityManager.merge(utente);
			
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		return eraAttivo;
	}
}
