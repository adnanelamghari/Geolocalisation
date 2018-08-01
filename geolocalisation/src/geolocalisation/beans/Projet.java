package geolocalisation.beans;

public class Projet {
	private String titre;
	private String description;
	private String id_doc;
	private String pays;
	private String ecole;
	private String discipline;
	private String laboratoire;
	private String fileName;
	private Double latitude;
	private Double longitude;
	private int id_projet;

	

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projet(String titre, String description, String id_doc, String ecole, String discipline,
			String laboratoire, Double latitude, Double longitude) {
		super();
		this.titre = titre;
		this.description = description;
		this.id_doc = id_doc;
		this.ecole = ecole;
		this.discipline = discipline;
		this.laboratoire = laboratoire;
		this.longitude=longitude;
		this.latitude=latitude;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public String getLaboratoire() {
		return laboratoire;
	}
	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public int getId_projet() {
		return id_projet;
	}
	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}
	public String getId_doc() {
		return id_doc;
	}
	public void setId_doc(String id_doc) {
		this.id_doc = id_doc;
	}
}
