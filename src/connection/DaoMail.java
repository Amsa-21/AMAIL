package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import messagerie.Mail;

public class DaoMail {
	
	public static void create(Mail user) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into mail (destinataire, expediteur, objet, message) values (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getDestinataire());
			ps.setString(2, user.getExpediteur());
			ps.setString(3, user.getObjet());
			ps.setString(4, user.getMessage());
			ps.execute();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static boolean check(int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return false;
	}
	
	public static int checkMail(Mail mail) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where destinataire=? AND expediteur=? AND objet=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, mail.getDestinataire());
			ps.setString(2, mail.getExpediteur());
			ps.setString(3, mail.getObjet());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return 0;
	}
	
	public static boolean checkDestinataire(String destinataire) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where destinataire=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, destinataire);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return false;
	}
	
	public static int getDBId(Mail usr) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where expediteur=? AND objet=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, usr.getExpediteur());
			ps.setString(2, usr.getObjet());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return 0;
	}
	
	public static Mail read(int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String destinataire = rs.getString("destinataire");
				String expediteur = rs.getString("expediteur");
				String objet = rs.getString("objet");
				String message = rs.getString("message");
				Mail user = new Mail (destinataire, expediteur, objet, message);
				return user;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return null;
	}
	
	public static List<Mail> list(String user0) throws Exception {
		List<Mail> users = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where destinataire=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user0);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String destinataire = rs.getString("destinataire");
				String expediteur = rs.getString("expediteur");
				String objet = rs.getString("objet");
				String message = rs.getString("message");
				Mail user = new Mail (destinataire, expediteur, objet, message);
				users.add(user);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return users;
	}
	
	public static void delete(int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From mail Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void truncate() throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "truncate table mail";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static List<Mail> listSend(String email) throws Exception {
		List<Mail> users = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From mail where expediteur=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String destinataire = rs.getString("destinataire");
				String expediteur = rs.getString("expediteur");
				String objet = rs.getString("objet");
				String message = rs.getString("message");
				Mail user = new Mail (destinataire, expediteur, objet, message);
				users.add(user);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return users;
	}
	
}