package bibliotecaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bibliotecaweb.service.MyServiceFactory;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titolo")
	private String titolo;
	// @Column(name = "genere")
	@Enumerated(EnumType.STRING)
	private Genere genere;
	@Column(name = "trama")
	private String trama;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "autore_id")
	private Autore autore;
	
	public Libro() {}
	
	public Libro(Long id, String titolo, Genere genere, String trama, Autore autore) {
		this.id = id;
		this.titolo = titolo;
		this.genere = genere;
		this.trama = trama;
		this.autore = autore;
	}
	
	public Libro(String titolo, Genere genere, String trama) {
		this(null, titolo, genere, trama, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public void addAutore(Autore autore) throws Exception {
		MyServiceFactory.getLibroServiceInstance().aggiungi(this, autore);
	}
	
	public enum Genere {
		STORICO,
		FANTASCIENZA,
		FANTASY,
		AVVENTURA,
		FORMAZIONE,
		RAGAZZI,
		HORROR,
		GIALLO_NOIR_THRILLER,
		ROSA,
		EROTICO,
		PSICOLOGICO,
		UMORISTICO,
		SOCIALE,
		EPISTOLARE,
		FIABA_FAVOLA,
		STORIOGRAFIA,
		BIOGRAFIA,
		DIARIO,
		DIVULGATIVO,
		ORATORIA,
		POESIA,
		EPICA,
		TEATRO,
		OPERA_MUSICAL;	
	}
}
