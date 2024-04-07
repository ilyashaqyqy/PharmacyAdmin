create table Produit (
    id_produit  SERIAL PRIMARY KEY,
    nom_article VARCHAR(55) NOT NULL,
    quantite INT NOT NULL,
    prix  FLOAT NOT NULL,
    description  VARCHAR(155) NOT NULL
);