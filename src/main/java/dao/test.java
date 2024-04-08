package dao;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import metier.entities.Produit;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduitDaoImpl produitDaoImpl = new ProduitDaoImpl() ;
		Produit p3 = new   Produit("vitamin c", 90, 500, "vittaaamiinn") ;
		Produit p4 = new   Produit("pitadin", 40, 70, "pitaddiinnn") ;
		Produit p5 = new   Produit("parasitamol", 40, 70, "paracitamol") ;
		Produit p6 = new   Produit("parasl", 40, 70, "paracitamol") ;
		

//		produitDaoImpl.save(p3);
//		produitDaoImpl.save(p4);
//		produitDaoImpl.save(p6);
//		System.out.println(p6);
		
	
        List<Produit> prods = produitDaoImpl.produitsParMc("doli");
        
        // Display the found products
        for (Produit produit : prods) {
            System.out.println(produit);
        }
		
	}

}



