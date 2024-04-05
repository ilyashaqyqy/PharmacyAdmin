package dao;

import metier.entities.Produit;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduitDaoImpl produitDaoImpl = new ProduitDaoImpl() ;
		Produit p1 = new   Produit("doli", 10, 50, "vvvv") ;
		
		produitDaoImpl.save(p1);
		
	}

}
