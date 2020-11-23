package bibliotecaweb.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "ID"))
	private Set<Ruolo> ruoli = new HashSet<>(0);
	
	@Enumerated(EnumType.STRING)
	private Stato stato = Stato.NON_ATTIVO;
	
	public Utente() {}
	
	public Utente(Long id, String nome, String cognome, String username, String password, Stato stato, Set<Ruolo> ruoli) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.stato = stato;
		this.ruoli = ruoli;
	}
	
	public Utente(String nome, String cognome, String username) {
		this(null, nome, cognome, username, "password", Stato.NON_ATTIVO, new HashSet<>(0));
	}

	public Utente(String username, String password, Stato stato) {
		this(null, null, null, username, password, Stato.NON_ATTIVO, new HashSet<>(0));
	}

	public Utente(Long id, String nome, String cognome, String username, Stato stato, Set<Ruolo> ruoli) {
		this(null, nome, cognome, username, null, stato, ruoli);
	}

	public Utente(String nome, String cognome, String username, Stato stato,
			Set<Ruolo> ruoli) {
		this(null, nome, cognome, username, stato, ruoli);
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

	public boolean isGuest() {
		Ruolo guest = new Ruolo(Ruolo.Codice.GUEST_ROLE);
		for (Ruolo ruolo : ruoli) {
			if (ruolo.equals(guest)) { return true; }
		}
		return false;
	}

	public boolean isAdmin() {
		Ruolo admin = new Ruolo(Ruolo.Codice.ADMIN_ROLE);
		for (Ruolo ruolo : ruoli) {
			if (ruolo.equals(admin)) { return true; }
		}
		return false;
	}
	
	public boolean isClassic() {
		Ruolo admin = new Ruolo(Ruolo.Codice.CLASSIC_ROLE);
		for (Ruolo ruolo : ruoli) {
			if (ruolo.equals(admin)) { return true; }
		}
		return false;
	}
	
	public boolean disattiva() {
		boolean eraAttivo = stato == Stato.ATTIVO;
		stato = Stato.NON_ATTIVO;
		return eraAttivo;
	}
	
	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username="
				+ username + ", password=" + password + ", stato=" + stato + "]";
	}

	public enum Stato {
		ATTIVO, NON_ATTIVO;
	}
}
