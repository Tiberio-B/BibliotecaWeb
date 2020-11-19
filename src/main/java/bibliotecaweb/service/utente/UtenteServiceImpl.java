package bibliotecaweb.service.utente;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import bibliotecaweb.dao.EntityManagerUtil;
import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.dao.utente.UtenteDAO;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.model.Utente.Stato;
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

	@Override
	public List<Utente> cerca(String nomeInput, String cognomeInput, String usernameInput,
			String statoInput, String[] ruoliIdInput) throws Exception {
		String cognome = cognomeInput.isEmpty() ? null : cognomeInput;
		String nome = nomeInput.isEmpty() ? null : nomeInput;
		String username = usernameInput.isEmpty() ? null : usernameInput;
		Utente.Stato stato = statoInput.isEmpty() ? null : Stato.valueOf(statoInput);	
		Set<Ruolo> ruoli = MyServiceFactory.getRuoloServiceInstance().carica(ruoliIdInput);
		Utente utente = new Utente(nome, cognome, username, stato, ruoli);
		return MyServiceFactory.getUtenteServiceInstance().cerca(utente);
	}
}
