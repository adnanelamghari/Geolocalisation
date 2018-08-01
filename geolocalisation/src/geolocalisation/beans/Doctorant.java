package geolocalisation.beans;

import java.sql.Date;

public class Doctorant {
	private String userName;
	private String nom;
	private String prenom;
	private String mail;
	private Date dateNaissance;
	private String facebookUrl;
	private String linkedInUrl;
	private String biographie;
	private String telephone;
	private String enumMessage;
	private String enumProjet;
	private String enumProfile;
	private String pictureName;
	
	
	@Override
	public String toString() {
		return "Doctorant [userName=" + userName + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", dateNaissance=" + dateNaissance + ", facebookUrl=" + facebookUrl + ", linkedInUrl=" + linkedInUrl
				+ ", biographie=" + biographie + ", telephone=" + telephone + ", enumMessage=" + enumMessage
				+ ", enumProjet=" + enumProjet + ", enumProfile=" + enumProfile + ", pictureName=" + pictureName + "]";
	}

	public Doctorant(String userName, String nom, String prenom, String mail, Date dateNaissance, String facebookUrl,
			String linkedInUrl, String biographie, String telephone, String enumMessage, String enumProjet,
			String enumProfile) {
		super();
		this.userName = userName;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.dateNaissance=dateNaissance;
		this.facebookUrl = facebookUrl;
		this.linkedInUrl = linkedInUrl;
		this.biographie = biographie;
		this.telephone = telephone;
		this.enumMessage = enumMessage;
		this.enumProjet = enumProjet;
		this.enumProfile = enumProfile;
	}
	
	public Doctorant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getFacebookUrl() {
		return facebookUrl;
	}
	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}
	public String getLinkedInUrl() {
		return linkedInUrl;
	}
	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}
	public String getBiographie() {
		return biographie;
	}
	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}
	public String getEnumMessage() {
		return enumMessage;
	}
	public void setEnumMessage(String enumMessage) {
		this.enumMessage = enumMessage;
	}
	public String getEnumProjet() {
		return enumProjet;
	}
	public void setEnumProjet(String enumProjet) {
		this.enumProjet = enumProjet;
	}
	public String getEnumProfile() {
		return enumProfile;
	}
	public void setEnumProfile(String enumProfile) {
		this.enumProfile = enumProfile;
	}
	
	
	
}
