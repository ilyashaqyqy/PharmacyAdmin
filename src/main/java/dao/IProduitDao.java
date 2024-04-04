package dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {

	public Produit save(Produit p);
	public List <Produit> produit(Long id);
	public Produit getProduit(Long id);
	public Produit update (Produit p);
	public void deleteProduit(Long id);
	
}
