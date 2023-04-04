package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import messagerie.Utilisateur;

public class DaoUser {
	
	public static void create(Utilisateur user) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into utilisateur (prenom, nom, email, password, birthday, telephone, adresse) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getPrenom());
			ps.setString(2, user.getNom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getBirthday());
			ps.setString(6, user.getTelephone());
			ps.setString(7, user.getAdresse());
			ps.execute();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static boolean check(int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From utilisateur where id=?";
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
	
	public static boolean checkEmail(String email) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From utilisateur where email=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return false;
	}
	
	public static int getDBId(Utilisateur usr) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From utilisateur where email=? AND password=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, usr.getEmail());
			ps.setString(2, usr.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return 0;
	}
	
	public static Utilisateur read(int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From utilisateur where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String birthday = rs.getString("birthday");
				String telephone = rs.getString("telephone");
				String adresse = rs.getString("adresse");
				Utilisateur user = new Utilisateur (prenom, nom, email, password, birthday, telephone, adresse);
				return user;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			return null;
	}
	
	public static List<Utilisateur> list() throws Exception {
		List<Utilisateur> users = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From utilisateur";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String birthday = rs.getString("birthday");
				String telephone = rs.getString("telephone");
				String adresse = rs.getString("adresse");
				Utilisateur user = new Utilisateur (prenom, nom, email, password, birthday, telephone, adresse);
				users.add(user);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return users;
	}
	
	public static void update(Utilisateur user,int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update utilisateur Set prenom=?, nom=?, email=?, password=?, birthday=?, telephone=?, adresse=? Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getPrenom());
			ps.setString(2, user.getNom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getNom());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getPassword());
			ps.setInt(8, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void delete(int id) throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From utilisateur Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static void truncate() throws Exception {
		try (Connection connection = DBManager.getConnection()) {
			String query = "truncate table utilisateur;";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}