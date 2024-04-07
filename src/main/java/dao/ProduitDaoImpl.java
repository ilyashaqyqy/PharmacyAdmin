package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao{



	@Override
	public Produit save(Produit p) {
	    Connection connection = SingletonConnection.getConnection();
	    
	    try {
	        // Check if the product already exists
	        if (isProductExists(p)) {
	            System.out.println("Produit avec des détails similaires existe déjà. Insertion ignorée.");
	            return p;
	        }
	        
	        PreparedStatement ps = connection.prepareStatement(
	            "INSERT INTO Produit (nom_article, quantite, prix, description) VALUES (?, ?, ?, ?)"
	        );
	        ps.setString(1, p.getNom_article());
	        ps.setInt(2, p.getQuantite());
	        ps.setFloat(3, p.getPrix());
	        ps.setString(4, p.getDiscription());  
	        ps.executeUpdate();
	        ps.close(); // Close the PreparedStatement
	        
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

	private boolean isProductExists(Produit p) throws SQLException {
	    Connection connection = SingletonConnection.getConnection();
	    PreparedStatement ps = connection.prepareStatement(
	        "SELECT COUNT(*) AS count FROM Produit WHERE nom_article = ? AND quantite = ? AND prix = ? AND description = ?"
	    );
	    ps.setString(1, p.getNom_article());
	    ps.setInt(2, p.getQuantite());
	    ps.setFloat(3, p.getPrix());
	    ps.setString(4, p.getDiscription());  
	    ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        int count = rs.getInt("count");
	        return count > 0;
	    }
	    return false;
	}


	
	
	
	
	
	

	@Override
	public List<Produit> produitsParMc(String mc) {
		Connection connection = SingletonConnection.getConnection();
		List<Produit> produits = new ArrayList <Produit> ();
		
	    try {
			PreparedStatement ps = connection.prepareStatement(
			        "SELECT *  FROM Produit WHERE nom_article LIKE ?"
			    );
			ps.setString(1,mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p = new Produit();
				p.setId_produit(rs.getLong("Id_produit"));
				p.setNom_article(rs.getString("Nom_article"));
				p.setQuantite(rs.getInt("Quantite"));
				p.setPrix(rs.getFloat("Prix"));
				p.setDiscription(rs.getString("description"));
				
				produits.add(p);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return produits;
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
