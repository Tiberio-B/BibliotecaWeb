package bibliotecaweb.service;

import java.util.List;

import bibliotecaweb.dao.IBaseDAO;
import bibliotecaweb.model.Autore;

public interface GenericService<T> {
	
	public IBaseDAO<T> getDAO();
	
	public void setDAO(IBaseDAO<T> tDAO); //per injection

	public List<T> elenca() throws Exception;

	public T carica(Long id) throws Exception;
	
	public List<T> cerca(T instance) throws Exception;

	public void aggiorna(T instance) throws Exception;

	public void inserisci(T instance) throws Exception;

	public void rimuovi(T instance) throws Exception;
	
	public List<T> trovaDa(T instance) throws Exception;
}
