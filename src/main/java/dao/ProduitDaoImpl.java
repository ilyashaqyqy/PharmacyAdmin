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
	    Connection connection = SingletonConnection.getConnection();
	    
	    try {
	        PreparedStatement ps = connection.prepareStatement(
	            "INSERT INTO Produit (nom_article, quantite, prix, description) VALUES (?, ?, ?, ?)"
	        );
	        ps.setString(1, p.getNom_article());
	        ps.setInt(2, p.getQuantite());
	        ps.setFloat(3, p.getPrix());
	        ps.setString(4, p.getDiscription());  
	        ps.executeUpdate();
	        ps.close(); // Close the first PreparedStatement
	        
	        // Retrieve the generated ID
	        PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(id_produit) AS max_id FROM Produit");
	        ResultSet rs = ps2.executeQuery();
	        if (rs.next()) {
	            long generatedId = rs.getLong("max_id");
	            p.setId_produit(generatedId); // Update the Produit object with the generated ID
	        }
	        rs.close();
	        ps2.close(); // Close the second PreparedStatement
	        
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
