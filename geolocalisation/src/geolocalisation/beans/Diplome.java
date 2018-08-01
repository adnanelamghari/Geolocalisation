package geolocalisation.beans;

public class Diplome {
	private String intitule;
	private String lieu;
	private String dateDebut;
	private String dateFin;
	private int idDiplome;
	private String idDoctorant;
	

	public Diplome(String intitule, String lieu, String dateDebut, String dateFin, String doctorantUserName) {
		super();
		this.intitule = intitule;
		this.lieu = lieu;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.idDoctorant=doctorantUserName;
	}
	
	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getIdDoctorant() {
		return idDoctorant;
	}

	public void setIdDoctorant(String idDoctorant) {
		this.idDoctorant = idDoctorant;
	}

	public int getIdDiplome() {
		return idDiplome;
	}

	public void setIdDiplome(int idDiplome) {
		this.idDiplome = idDiplome;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}	
}
