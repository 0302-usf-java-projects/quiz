package repo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class UserDAO {
	public void insertUser(User user) {
		int id = user.getUser_id();
		String password = user.getPassword();
		String userName = user.getUsername();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		int roleId = user.getRoleId();
		int newID = this.findAll().size();
		try(Connection conn = ConnectionUtil.connect())
		{
			CallableStatement stmt= conn.prepareCall("call insert_user(?,?, ?, ?, ?,?)"); 
			stmt.setInt(1, newID);
			stmt.setString(2, userName);
			stmt.setString(3, password);
			stmt.setString(4, firstName);
			stmt.setString(5, lastName);
			stmt.setInt(6, roleId);
			stmt.execute();
		} catch(SQLException e) {
		e.printStackTrace();
		}
	}
	
	public Set<User> findAll() {
		Set<User> results = new HashSet<>();
		User result;
		try(Connection conn = ConnectionUtil.connect())
		{
			Statement stmt= conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from app_user;");
			while (rs.next()) {
				int userID = rs.getInt("user_id");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int role = rs.getInt("role_id");
				result = new User(userID, userName, password, firstName, lastName, role);
				results.add(result);
		
			}
	

			
		} catch(SQLException e) {
		e.printStackTrace();
		}
		return results;
	}
	
	public User findById(int id) {
		return null;
	}
	
	public User findByUserName(String username) {
		User result = null;
		try(Connection conn = ConnectionUtil.connect())
		{
			Statement stmt= conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from app_user where username = username;");
			while (rs.next()) {
				int userID = rs.getInt("user_id");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int role = rs.getInt("role_id");
				result = new User(userID, userName, password, firstName, lastName, role);
				
		
			}
			
		} catch(SQLException e) {
		e.printStackTrace();
		}
		return result;
	}
	
	public User findByCredentials(String username, String password) {
		User result = null;
		try(Connection conn = ConnectionUtil.connect())
		{
			PreparedStatement stmt= conn.prepareStatement("select * from app_user where username = ? and password = ?; ");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int userID = rs.getInt("user_id");
				String userName = rs.getString("username");
				String password2 = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int role = rs.getInt("role_id");
				result = new User(userID, userName, password, firstName, lastName, role);
				
		
			}
			
		} catch(SQLException e) {
		e.printStackTrace();
		}
		return result;
		///WHERE (city = 'Miami' AND first_name = 'Sarah')
	}
	
	public boolean updateUser(User user) {
		int id = user.getUser_id();
		String password = user.getPassword();
		String userName = user.getUsername();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		int roleId = user.getRoleId();
	
		try(Connection conn = ConnectionUtil.connect())
		{
			PreparedStatement stmt= conn.prepareStatement("update app_user set user_id = ?, username = ?, password = ?, first_name =?, last_name =?, role_id =? where user_id = ? ");
			stmt.setInt(1, id);
			stmt.setString(2, userName);
			stmt.setString(3, password);
			stmt.setString(4, firstName);
			stmt.setString(5, lastName);
			stmt.setInt(6, roleId);
			stmt.setInt(7, id);
			stmt.executeUpdate();
		} catch(SQLException e) {
		e.printStackTrace();
		return false;
		}
		return true;
	}
	
	public boolean deleteById(int id) {
		try(Connection conn = ConnectionUtil.connect())
		{
			PreparedStatement stmt= conn.prepareStatement("delete from app_user where user_id = ?; ");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			
		} catch(SQLException e) {
		e.printStackTrace();
		return false;
		}
	return true;
	}
	
	}

//	public void updateUser(User user) {
//		
//	}
//	
//	public void deleteById(int id) {
//		
	//}

