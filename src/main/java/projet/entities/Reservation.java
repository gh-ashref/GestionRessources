package projet.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int freq;
	private Date dateDebutFreq;
	private Date dateFinFreq;
	@ManyToOne
	private Personne Personne;
	public Reservation(Long id, int freq, Date dateDebutFreq, Date dateFinFreq, projet.entities.Personne personne) {
		super();
		this.id = id;
		this.freq = freq;
		this.dateDebutFreq = dateDebutFreq;
		this.dateFinFreq = dateFinFreq;
		Personne = personne;
	}
	public Reservation(int freq, Date dateDebutFreq, Date dateFinFreq, projet.entities.Personne personne) {
		super();
		this.freq = freq;
		this.dateDebutFreq = dateDebutFreq;
		this.dateFinFreq = dateFinFreq;
		Personne = personne;
	}
	public Reservation() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public Date getDateDebutFreq() {
		return dateDebutFreq;
	}
	public void setDateDebutFreq(Date dateDebutFreq) {
		this.dateDebutFreq = dateDebutFreq;
	}
	public Date getDateFinFreq() {
		return dateFinFreq;
	}
	public void setDateFinFreq(Date dateFinFreq) {
		this.dateFinFreq = dateFinFreq;
	}
	public Personne getPersonne() {
		return Personne;
	}
	public void setPersonne(Personne personne) {
		Personne = personne;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Personne == null) ? 0 : Personne.hashCode());
		result = prime * result + ((dateDebutFreq == null) ? 0 : dateDebutFreq.hashCode());
		result = prime * result + ((dateFinFreq == null) ? 0 : dateFinFreq.hashCode());
		result = prime * result + freq;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (Personne == null) {
			if (other.Personne != null)
				return false;
		} else if (!Personne.equals(other.Personne))
			return false;
		if (dateDebutFreq == null) {
			if (other.dateDebutFreq != null)
				return false;
		} else if (!dateDebutFreq.equals(other.dateDebutFreq))
			return false;
		if (dateFinFreq == null) {
			if (other.dateFinFreq != null)
				return false;
		} else if (!dateFinFreq.equals(other.dateFinFreq))
			return false;
		if (freq != other.freq)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}