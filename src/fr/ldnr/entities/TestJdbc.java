package fr.ldnr.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TestJdbc {

	public static void main(String[] args) throws Exception {
		ArrayList<Article> articles = new ArrayList<Article>();

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2023";

		try (Connection connection = DriverManager.getConnection(url, login, password)) {
			String strSql = "SELECT * FROM T_Articles";
			String strSql1 = "INSERT INTO t_articles (description,brand,unitaryprice) VALUE ('Iphone14','Apple','1099')"; // Exercice3
			String strSql2 = "update t_articles set UnitaryPrice = 999 where IdArticle = 16"; // Exercice3
			String strSql3 = "delete from t_articles where IdArticle = 2"; // Exercice3
			String strSql4 = "SELECT * FROM T_Articles where IdArticle = 1"; // Exercice3
			

			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(strSql4)) {
					while (resultSet.next()) {
						int rsIdUser = resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsBrand = resultSet.getString(3);
						double rsPrice = resultSet.getDouble(4);
						articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
					}
				}
			}

			for (Article a : articles) {
				System.out
						.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
