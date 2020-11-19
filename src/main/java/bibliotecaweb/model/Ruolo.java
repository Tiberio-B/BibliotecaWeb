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
	
	public Ruolo(Codice codice) {
		this(codice, null);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		Ruolo ruolo = (Ruolo) obj;
		if (codice != ruolo.codice) { return false; }
		return true;
	}

	public enum Codice {
		ADMIN_ROLE,
		CLASSIC_ROLE,
		GUEST_ROLE
	}
}