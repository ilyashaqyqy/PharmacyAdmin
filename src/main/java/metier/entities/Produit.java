package metier.entities;

import java.io.Serializable;




public class Produit implements Serializable{

	private long id_produit ;
	private String nom_article ;
	private int quantite;
	private float  prix ;
	private String discription ;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String nom_article, int quantite, float prix, String discription) {
		super();
		this.nom_article = nom_article;
		this.quantite = quantite;
		this.prix = prix;
		this.discription = discription;
	}
	public long getId_produit() {
		return id_produit;
	}
	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom_article=" + nom_article + ", quantite=" + quantite
				+ ", prix=" + prix + ", discription=" + discription + "]";
	}
	
	
	
}

