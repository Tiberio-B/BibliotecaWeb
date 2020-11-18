package bibliotecaweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import bibliotecaweb.service.MyServiceFactory;

@Entity
@Table(name = "utente")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	@ManyToMany
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "ID"))
	private Set<Ruolo> ruoli = new HashSet<>(0);
	
	@Enumerated(EnumType.STRING)
	private Stato stato = Stato.NON_ATTIVO;
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String username, String password, Set<Ruolo> ruoli, Stato stato) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruoli = ruoli;
		this.stato = stato;
	}
	
	public Utente(String nome, String cognome, String username) {
		this(nome, cognome, username, "password", new HashSet<>(0), Stato.NON_ATTIVO);
	}

	public Utente(String username, String password, Stato stato) {
		this(null, null, username, password, new HashSet<>(0), Stato.NON_ATTIVO);
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public void addRuolo(Ruolo ruolo) throws Exception {
		MyServiceFactory.getUtenteServiceInstance().aggiungi(this, ruolo);
	}

	public Object isGuest() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public enum Stato {
		ATTIVO, NON_ATTIVO;
	}
}
