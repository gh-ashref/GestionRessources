package projet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class CreneauRejete implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		private Date dateNonDispo;
		private int qteDispo;
		@ManyToOne(cascade=CascadeType.MERGE)
		private Reservation reservation;

		@ManyToOne(cascade = CascadeType.MERGE)
		private Ressource ressource;
		private int heured;
		private int heuref;
		private String heureDebut;
		
		private String heureFin;
		
		public CreneauRejete() {
			super();
		}
		public CreneauRejete(Date dateNonDispo, int qteDispo, Reservation reservation, Ressource ressource,
				int heured2, int heuref2) {
			super();
			this.dateNonDispo = dateNonDispo;
			this.qteDispo = qteDispo;
			this.reservation = reservation;
			this.ressource = ressource;
			this.heured = heured2;
			this.heuref = heuref2;
			this.heureDebut = intToString(heured);
			this.heureFin = intToString(heuref);
			
			

		}
		public String getHeureDebut() {
			return heureDebut;
		}

		public void setHeureDebut(String heureDebut) {
			this.heureDebut = heureDebut;
		}

		public String getHeureFin() {
			return heureFin;
		}

		public void setHeureFin(String heureFin) {
			this.heureFin = heureFin;
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

		public Reservation getReservation() {
			return reservation;
		}

		public void setReservation(Reservation reservation) {
			this.reservation = reservation;
		}

		public Ressource getRessource() {
			return ressource;
		}

		public void setRessource(Ressource ressource) {
			this.ressource = ressource;
		}

		public Date getDateNonDispo() {
			return dateNonDispo;
		}

		public void setDateNonDispo(Date dateNonDispo) {
			this.dateNonDispo = dateNonDispo;
		}

		public int getQteDispo() {
			return qteDispo;
		}

		public void setQteDispo(int qteDispo) {
			this.qteDispo = qteDispo;
		}

		@Override
		public String toString() {
			return "CreneauRejete [dateNonDispo=" + dateNonDispo + ", qteDispo=" + qteDispo + ", reservation="
					+ reservation + ", ressource=" + ressource + ", heured=" + heured + ", heuref=" + heuref + "]";
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dateNonDispo == null) ? 0 : dateNonDispo.hashCode());
			result = prime * result + ((heureDebut == null) ? 0 : heureDebut.hashCode());
			result = prime * result + ((heureFin == null) ? 0 : heureFin.hashCode());
			result = prime * result + heured;
			result = prime * result + heuref;
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + qteDispo;
			result = prime * result + ((reservation == null) ? 0 : reservation.hashCode());
			result = prime * result + ((ressource == null) ? 0 : ressource.hashCode());
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
			CreneauRejete other = (CreneauRejete) obj;
			if (dateNonDispo == null) {
				if (other.dateNonDispo != null)
					return false;
			} else if (!dateNonDispo.equals(other.dateNonDispo))
				return false;
			if (heureDebut == null) {
				if (other.heureDebut != null)
					return false;
			} else if (!heureDebut.equals(other.heureDebut))
				return false;
			if (heureFin == null) {
				if (other.heureFin != null)
					return false;
			} else if (!heureFin.equals(other.heureFin))
				return false;
			if (heured != other.heured)
				return false;
			if (heuref != other.heuref)
				return false;
			if (id != other.id)
				return false;
			if (qteDispo != other.qteDispo)
				return false;
			if (reservation == null) {
				if (other.reservation != null)
					return false;
			} else if (!reservation.equals(other.reservation))
				return false;
			if (ressource == null) {
				if (other.ressource != null)
					return false;
			} else if (!ressource.equals(other.ressource))
				return false;
			return true;
		}
	}
