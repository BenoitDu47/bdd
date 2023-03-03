package fr.ldnr;

import java.util.ArrayList;

import fr.ldnr.dao.ArticleDao;
import fr.ldnr.dao.UserDao;
import fr.ldnr.entities.Article;
import fr.ldnr.entities.User;

public class Shop {
	public static void main(String[] args) {
		
		ArticleDao articleDao = new ArticleDao();
		UserDao userDao = new UserDao();
	
		// articleDao.create(new Article("MacbookPro", "Apple", 3999));
		// articleDao.delete(new Article(19));
		// articleDao.update(new Article(17,"Macbook","Apple",6555));
		// System.out.println(articleDao.read(3));
		// articleDao.readAll();
		
		// userDao.create(new User("Thomas", "123456"));
		// userDao.delete(new User(2));
		// userDao.update(new User(1,"Benoit", "12345"));
		// System.out.println(userDao.read(1));
		// userDao.readAll();
		 
		 
	}
}
