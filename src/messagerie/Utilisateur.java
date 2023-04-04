package messagerie;

public class Utilisateur {
	private String prenom;
	private String nom;
	private String email;
	private String password;
	private String birthday;
	private String telephone;
	private String adresse;
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Utilisateur(String prenom, String nom, String email, String password, String birthday, String telephone, String adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	
	public Utilisateur(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
