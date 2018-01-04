package projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Creneau implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Reservation Reservation;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Ressource Ressource;

	// private String heured;
	// private String heuref;
	private int heured;
	private int heuref;
	private Date date;
	private int qte;

	@Transient
	private String heureDebut;
	@Transient
	private String heureFin;

	public Creneau() {
	}

	public Creneau(long id, projet.entities.Reservation reservation, projet.entities.Ressource ressource, int heured,
			int heuref, Date date, int qte) {
		super();
		this.id = id;
		Reservation = reservation;
		Ressource = ressource;
		this.heured = heured;
		this.heuref = heuref;
		this.date = date;
		this.qte = qte;
		this.heureDebut = intToString(heured);
		this.heureFin = intToString(heuref);
	}

	public Creneau(projet.entities.Reservation reservation, projet.entities.Ressource ressource, int heured, int heuref,
			Date date, int qte) {
		super();
		Reservation = reservation;
		Ressource = ressource;
		this.heured = heured;
		this.heuref = heuref;
		this.date = date;
		this.qte = qte;
		this.heureDebut = intToString(heured);
		this.heureFin = intToString(heuref);
		System.out.println(heureDebut);
	}

	public String getHeureDebut() {
		return intToString(getHeured());
	}


	public String getHeureFin() {
		return intToString(getHeuref());
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Reservation getReservation() {
		return Reservation;
	}

	public void setReservation(Reservation reservation) {
		Reservation = reservation;
	}

	public Ressource getRessource() {
		return Ressource;
	}

	public void setRessource(Ressource ressource) {
		Ressource = ressource;
	}

	public int getHeured() {
		return heured;
	}

	public void setHeured(int heured) {
		this.heured = heured;
	}

	public int getHeuref() {
		return heuref;
	}

	public void setHeuref(int heuref) {
		this.heuref = heuref;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Reservation == null) ? 0 : Reservation.hashCode());
		result = prime * result + ((Ressource == null) ? 0 : Ressource.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + heured;
		result = prime * result + heuref;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + qte;
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
		Creneau other = (Creneau) obj;
		if (Reservation == null) {
			if (other.Reservation != null)
				return false;
		} else if (!Reservation.equals(other.Reservation))
			return false;
		if (Ressource == null) {
			if (other.Ressource != null)
				return false;
		} else if (!Ressource.equals(other.Ressource))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (heured != other.heured)
			return false;
		if (heuref != other.heuref)
			return false;
		if (id != other.id)
			return false;
		if (qte != other.qte)
			return false;
		return true;
	}

	public String intToString(int heure) {
		String s = "";
		int hh = heure / 60;
		int mm = heure % 60;
		if (hh < 10)
			s = s + "0" + hh;
		else
			s = s + hh;
		s = s + ":";
		if (mm < 10)
			s = s + "0" + mm;
		else
			s = s + mm;

		return s;
	}

}
