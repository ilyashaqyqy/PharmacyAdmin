package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao{



	@Override
	public Produit save(Produit p) {
		Connection connection= SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO Produit (nom_article , quantite  , prix  , description  ) VALUES (?,?,?,?)");
			ps.setString(1,p.getNom_article());
			ps.setInt(2, p.getQuantite());
			ps.setFloat(3, p.getPrix());
			ps.setString(4, p.getDiscription());  
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID AS MAX ID FORM PRODUITS");
			ResultSet rs = ps2.executeQuery();
			if (rs.next())
			
			ps.close();
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
				
				
		
		return p;
	}

	@Override
	public List<Produit> produit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		
	}

}
