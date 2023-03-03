package fr.ldnr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ldnr.entities.Article;

public class ArticleDao implements Dao<Article> {

	@Override
	public void create(Article obj) {
		try (Statement statement = connection.createStatement()) {
			String str = "INSERT INTO t_articles (description,brand,unitaryprice)" + " VALUE ('" + obj.getDescription()
					+ "','" + obj.getBrand() + "','" + obj.getPrice() + "');";
			int row = statement.executeUpdate(str);
			if (row == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createStatement(Article obj) {
		String str = "INSERT INTO t_articles (description,brand,unitaryprice) VALUE (?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)) {
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());
			if (ps.executeUpdate() == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article read(int id) {
		try (Statement statement = connection.createStatement()) {
			String str = "SELECT * FROM t_articles WHERE IdArticle =" + id;
			try (ResultSet resultSet = statement.executeQuery(str)) {
				if (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					Article article = new Article(rsIdUser, rsDescription, rsBrand, rsPrice);
					return article;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Article obj) {
		try (Statement statement = connection.createStatement()) {
			String str = "update t_articles set Description='" + obj.getDescription() + "', Brand='" + obj.getBrand()
					+ "', UnitaryPrice='" + obj.getPrice() + "' where IdArticle  =" + obj.getId();
			int row = statement.executeUpdate(str);
			if (row == 1) {
				System.out.println("Mise à jour ok");
			}
		} catch (SQLException e) {
			System.out.println("Article inexistant");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Article obj) {

		try (Statement statement = connection.createStatement()) {
			String str = "DELETE FROM t_articles WHERE IdArticle =" + obj.getId();
			int row = statement.executeUpdate(str);
			if (row > 0) {
				System.out.println("suppression ok");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Article inexistant");
		return false;

	}

	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		try (Statement statement = connection.createStatement()) {
			String str = "SELECT * FROM t_articles";
			try (ResultSet resultSet = statement.executeQuery(str)) {
				while (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
				}
			}
			for (Article a : articles) {
				System.out
						.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
