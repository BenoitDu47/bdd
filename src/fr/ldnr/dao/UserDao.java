package fr.ldnr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ldnr.entities.User;

public class UserDao implements Dao<User> {
//String login, String password
	@Override
	public void create(User obj) {
		try (Statement statement = connection.createStatement()) {
			String str = "INSERT INTO t_users (login,password)" + " VALUE ('" + obj.getLogin() + "','"
					+ obj.getPassword() + "');";
			int row = statement.executeUpdate(str);
			if (row == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createStatement(User obj) {
		String str = "INSERT INTO t_users (login,password) VALUE (?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			if (ps.executeUpdate() == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User read(int id) {
		try (Statement statement = connection.createStatement()) {
			String str = "SELECT * FROM t_users WHERE IdUser =" + id;
			try (ResultSet resultSet = statement.executeQuery(str)) {
				if (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					User user = new User(rsIdUser, rsLogin, rsPassword);
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(User obj) {
		try (Statement statement = connection.createStatement()) {
			String str = "update t_users set Login='" + obj.getLogin() + "', Password='" + obj.getPassword()
					+ "' where IdUser =" + obj.getId();
			int row = statement.executeUpdate(str);
			if (row == 1) {
				System.out.println("Mise à jour ok");
			}
		} catch (SQLException e) {
			System.out.println("User inexistant");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User obj) {
		try (Statement statement = connection.createStatement()) {
			String str = "DELETE FROM t_Users WHERE IdUser =" + obj.getId();
			int row = statement.executeUpdate(str);
			if (row > 0) {
				System.out.println("suppression ok");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("User inexistant");
		return false;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		try (Statement statement = connection.createStatement()) {
			String str = "SELECT * FROM t_users";
			try (ResultSet resultSet = statement.executeQuery(str)) {
				while (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);

					users.add((new User(rsIdUser, rsLogin, rsPassword)));
				}
			}
			for (User u : users) {
				System.out.println(u.getId() + " - " + u.getLogin() + " - " + u.getPassword());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
