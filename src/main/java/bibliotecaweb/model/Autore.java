package bibliotecaweb.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bibliotecaweb.service.MyServiceFactory;

@Entity
@Table(name = "autore")
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "ddn")
	private Date ddn;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "autore")
	private Set<Libro> libri = new HashSet<>(0);
	
	public Autore() {}
	
	public Autore(Long id, String nome, String cognome, Date ddn, Set<Libro> libri) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.ddn = ddn;
		this.libri = libri;
	}
	
	public Autore(String nome, String cognome, Date ddn) {
		this(null, nome, cognome, ddn, new HashSet<>(0));
	}

	public Autore(String nome, String cognome) {
		this(null, nome, cognome, null, new HashSet<>(0));
	}

	public Autore(Long id, String nome, String cognome, Set<Libro> libri) {
		this(id, nome, cognome, null, libri);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public Set<Libro> getLibri() {
		return libri;
	}

	public void setLibri(Set<Libro> libri) {
		this.libri = libri;
	}
}
