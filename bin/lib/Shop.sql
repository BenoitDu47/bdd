-- ------------------------------------------
-- --- Reconstruction de la base de donés ---
-- ------------------------------------------


DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;


-- ------------------------------------------------------
-- --- Constructeur de la table des articles en vente ---
-- ------------------------------------------------------

DROP DATABASE IF EXISTS T_Articles;
CREATE TABLE T_Articles (
	IdArticle	 	int(4) 			PRIMARY KEY AUTO_INCREMENT,
	Description 	varchar(30) 	NOT NULL,
	Brand			varchar(30)		NOT NULL,
	UnitaryPrice	float(8)		NOT NULL
) ENGINE = InnoDB;

DROP DATABASE IF EXISTS T_Users;
CREATE TABLE T_Users (
IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
Login varchar(20) NOT NULL,
Password varchar(20) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Souris' , 'Logitoch', 65);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Clavier' , 'Microhard', 49.5);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Systeme d''exploitation' , 'Fenetres Vistoulle', 150);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Tapis souris' , 'Chapeau Bleu', 5);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Cle USB 8 To' , 'Syno', 8);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Laptop' , 'PH', 1199);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'CD x 500' , 'CETME', 250);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD-R x 100' , 'CETME', 99);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'DVD+R x 100' , 'CETME', 105);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Batterie Laptop' , 'PH', 80);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'Casque Audio' , 'Syno', 105);
INSERT INTO T_Articles ( Description, Brand, UnitaryPrice ) VALUES ( 'WebCam' , 'Logitoch', 755);

INSERT INTO T_Users ( Login,Password ) VALUES ( 'Benoit' , '123456');




SELECT * FROM T_Users;



