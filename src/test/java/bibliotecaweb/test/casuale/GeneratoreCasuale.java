package bibliotecaweb.test.casuale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import bibliotecaweb.model.Autore;
import bibliotecaweb.model.Libro;
import bibliotecaweb.model.Ruolo;
import bibliotecaweb.model.Utente;
import bibliotecaweb.service.MyServiceFactory;


public class GeneratoreCasuale extends Random {

	private static final long serialVersionUID = 1L;

	private <T> T elementoCasuale(T[]... arrays) {
		List<T> lista = new ArrayList<>();
		for (T[] array : arrays) {
			for (T t : array) {
				lista.add(t);
			}
		}
		return elementoCasuale(lista);
	}
	
	private <T> T elementoCasuale(T[] array) {
		return array[nextInt(array.length)];
	}

	public <T> T elementoCasuale(List<T> lista) {
		return lista.get(nextInt(lista.size()));
	}

	public int nextInt(int min, int max) {
		return (nextInt(max - min + 1) + min);
	}

	boolean coinFlip() {
		return (nextInt(2) > 0) ? true : false;
	}

	public String nomeCasuale() {
		return elementoCasuale(LoremIpsum.NOMI);
	}

	public String cognomeCasuale() {
		return elementoCasuale(LoremIpsum.COGNOMI);
	}
	
	public String nomeCompletoCasuale() {
		return nomeCasuale() + " " + cognomeCasuale();
	}
		
	public Libro.Genere genereCasuale() {
		return elementoCasuale(Libro.Genere.values());
	}
	
	public Libro libroCasuale() throws Exception {
		return elementoCasuale(MyServiceFactory.getLibroServiceInstance().elenca());
	}
	
	public Ruolo ruoloCasuale() throws Exception {
		return elementoCasuale(MyServiceFactory.getRuoloServiceInstance().elenca());
	}
	
	public Autore autoreCasuale() throws Exception {
		return elementoCasuale(MyServiceFactory.getAutoreServiceInstance().elenca());
	}
	
	public Utente utenteCasuale() throws Exception {
		return elementoCasuale(MyServiceFactory.getUtenteServiceInstance().elenca());
	}

	@SuppressWarnings("deprecation")
	Date dataCasuale(int giornoMin, int giornoMax, int meseMin, int meseMax, int annoMin,
			int annoMax) {
		int giorno = nextInt(giornoMin, giornoMax);
		int mese = nextInt(meseMin, meseMax);
		int anno = nextInt(annoMin, annoMax);
		return new Date(anno - 1900, mese - 1, giorno);
	}
	
	public Date ddnCasuale() {
		return dataCasuale(1, 28, 1, 12, 1950, 2005);
	}

	public String recapitoCasuale() {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < 10; i++)
			ret.append(nextInt(10));
		return ret.toString();
	}

	public float prezzoCasuale() {
		float prezzo = nextFloat();
		prezzo = coinFlip() ? prezzo * 100 : prezzo * 10;
		return ((int) ((prezzo + 0.005f) * 100)) / 100f;
	}
	
	public String indirizzoCasuale() {
		return elementoCasuale(LoremIpsum.DUG) + " " + nomeCompletoCasuale() + ", " + nextInt(1, 100);
	}
	public String cvcvcv() {
		return elementoCasuale(LoremIpsum.CVCVCVCV);
	}

	public String loremIpsum() {
		return LoremIpsum.loremIpsum;
	}
}
