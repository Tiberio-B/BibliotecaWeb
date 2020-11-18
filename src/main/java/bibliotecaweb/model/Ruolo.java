package bibliotecaweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Codice codice;
	@Column(name = "descrizione")
	private String descrizione;
	
	public Ruolo() {}
	
	public Ruolo(Codice codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}
	
	public Ruolo(Codice codiceRuolo) {
		this(codiceRuolo, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Codice getCodice() {
		return codice;
	}

	public void setCodice(Codice codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public enum Codice {
		ADMIN_ROLE,
		CLASSIC_ROLE,
		GUEST_ROLE
	}
}