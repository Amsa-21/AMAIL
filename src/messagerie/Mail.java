package messagerie;

public class Mail {
	private String destinataire;
	private String expediteur;
	private String objet;
	private String message;
	
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Mail(String destinataire, String expediteur, String objet, String message) {
		this.destinataire = destinataire;
		this.expediteur = expediteur;
		this.objet = objet;
		this.message = message;
	}
	public Mail(String destinataire, String expediteur, String objet) {
		this.destinataire = destinataire;
		this.expediteur = expediteur;
		this.objet = objet;
	}
	
}
