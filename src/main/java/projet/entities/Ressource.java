package projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Ressource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String libelle;
	private String description;
	private int qte ;
	private String type;
	private String etat;
	

	private int maxReserv;
	
	public Ressource() {
		super();
	}


	
	public Ressource(String libelle, String description, int qte, String type, String etat, int maxReserv) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.qte = qte;
		this.type = type;
		this.etat = etat;
		this.maxReserv = maxReserv;
	}



	@Override
	public String toString() {
		return "Ressource [id=" + id + ", libelle=" + libelle + ", description=" + description + ", qte=" + qte
				+ ", type=" + type + ", etat=" + etat + ", maxReserv=" + maxReserv + "]";
	}



	public Ressource(Long id, String libelle, String description, int qte, String type, String etat, int maxReserv) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.qte = qte;
		this.type = type;
		this.etat = etat;
		this.maxReserv = maxReserv;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getQte() {
		return qte;
	}



	public void setQte(int qte) {
		this.qte = qte;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}



	public int getMaxReserv() {
		return maxReserv;
	}



	public void setMaxReserv(int maxReserv) {
		this.maxReserv = maxReserv;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + maxReserv;
		result = prime * result + qte;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Ressource other = (Ressource) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (etat == null) {
			if (other.etat != null)
				return false;
		} else if (!etat.equals(other.etat))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (maxReserv != other.maxReserv)
			return false;
		if (qte != other.qte)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	} 
	
	
	
	
}
