package geolocalisation.beans;

public class Message {
	private String pseudoEmeteur;
	private String pseudoRecepteur;
	private String textMessage;
	private String dateEnvoi;
	private String heureEnvoi;
	
	
	
	public Message(String pseudoEmeteur, String pseudoRecepteur, String textMessage, String dateEnvoi,
			String heureEnvoi) {
		super();
		this.pseudoEmeteur = pseudoEmeteur;
		this.pseudoRecepteur = pseudoRecepteur;
		this.textMessage = textMessage;
		this.dateEnvoi = dateEnvoi;
		this.heureEnvoi = heureEnvoi;
	}
	public String getPseudoEmeteur() {
		return pseudoEmeteur;
	}
	public void setPseudoEmeteur(String pseudoEmeteur) {
		this.pseudoEmeteur = pseudoEmeteur;
	}
	public String getPseudoRecepteur() {
		return pseudoRecepteur;
	}
	public void setPseudoRecepteur(String pseudoRecepteur) {
		this.pseudoRecepteur = pseudoRecepteur;
	}
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	public String getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(String dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public String getHeureEnvoi() {
		return heureEnvoi;
	}
	public void setHeureEnvoi(String heureEnvoi) {
		this.heureEnvoi = heureEnvoi;
	}
	
}
