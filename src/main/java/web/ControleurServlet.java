package web;

import java.io.IOException;


import java.util.List;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;
@WebServlet(name="cs",urlPatterns={"*.php"})

public class ControleurServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IProduitDao metier ;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl ();
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String path=request.getServletPath();
		
		if(path.equals("/index.php")){
			request.getRequestDispatcher("produits.jsp").forward(request,response);
			
		}
		
		else if(path.equals("/chercher.php")) {
			String motCle=request.getParameter("motCle");
			ProduitModel model= new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits=metier.produitsParMc("%"+motCle+"%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request,response);
			
		}
		
		
		else if (path.equals("/Saisie.php")) {
			/* request.setAttribute("produit", new Produit()); */
			request.getRequestDispatcher("SaisieProduits.jsp").forward(request,response);
		}
		
		else if (path.equals("/SaveProduit.php")&&(request.getMethod().equals("POST")) ) {
			String article =request.getParameter("nom_article");
			int quantite =Integer.parseInt(request.getParameter("quantite"));
			float prix=Float.parseFloat(request.getParameter("prix"));
			String discription =request.getParameter("discription");
			
			
			Produit p=metier.save(new Produit(article,quantite,prix,discription));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request,response);
			
		}
		
		else if (path.equals("/Supprime.php")) {
		 Long id=Long.parseLong(request.getParameter("id_produit"));
		        metier.deleteProduit(id);
		    
		    // Redirection after deletion
		    response.sendRedirect("/PharmacyAdmin/chercher.php?motCle=");
		
		    
		
		} else {
			response.sendError(Response.SC_NOT_FOUND);
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}
}


