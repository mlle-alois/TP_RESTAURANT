CREATE TABLE Dessert(
	idDessert int(3) PRIMARY KEY,
	nomD varchar(50),
	prixD float(4,2)
);

CREATE TABLE Plat(
	idPlat int(3) PRIMARY KEY,
	nomP varchar(50),
	prixP float(4,2)
);

CREATE TABLE Alcool(
	idAlcool int(3) PRIMARY KEY,
	nomAlcool varchar(20),
	prixAlcool float(5,2),
	qteAlcool varchar(10),
	degreAlcool float(3,1)
);

CREATE TABLE Soft(
	idSoft int(3) PRIMARY KEY,
	nomSoft varchar(20),
	prixSoft float(5,2),
	qteSoft varchar(10),
	tauxSucre float(3,1)
);

CREATE TABLE Menu(
	idMenu int(3) PRIMARY KEY,
	idDessert int(3),
	idPlat int(3),
	idSoft int(3),
	idAlcool int(3),
	FOREIGN KEY (idDessert) REFERENCES Dessert (idDessert),
	FOREIGN KEY (idPlat) REFERENCES Plat (idPlat),
	FOREIGN KEY (idSoft) REFERENCES Soft (idSoft),
	FOREIGN KEY (idAlcool) REFERENCES Alcool (idAlcool)
);

CREATE TABLE Commande(
	numCommande int(5) PRIMARY KEY,
	nbrCouverts int(2),
	dateCommande date
);

CREATE TABLE Passer(
	idMenu int(3),
	numCommande int(5),
	FOREIGN KEY (idMenu) REFERENCES Menu (idMenu),
	FOREIGN KEY (numCommande) REFERENCES Commande (numCommande)
);

CREATE TABLE Facture(
	numFacture int(5) PRIMARY KEY,
	prixTotal float(7,2),
	numCommande int(5),
	FOREIGN KEY (numCommande) REFERENCES Commande (numCommande)
);

CREATE TABLE Utilisateur(
	idUser int(3) PRIMARY KEY,
	nomUser varchar(50),
	prenomUser varchar(50),
	mailUser varchar(200) UNIQUE,
	adrUser varchar(100),
	cpUser varchar(5),
	villeUser varchar(50),
	mdpUser varchar(128)
);

CREATE VIEW Boissons (idBoisson, nomBoisson, prixBoisson, qteBoisson) AS
	Select idSoft, nomSoft, prixSoft, qteSoft
	From Soft
	UNION
	Select idAlcool, nomAlcool, prixAlcool, qteAlcool
	From Alcool;