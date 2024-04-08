package web;

import java.io.IOException;
import java.util.List;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Produit;

public class ControleurServlet extends HttpServlet{
	
	private IProduitDao metier ;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl ();
	}

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String path=request.getServletPath();
		
		if(path.equals("/index.do")){
			request.getRequestDispatcher("produits.jsp").forward(request,response);
			
		}
		
		else if(path.equals("/chercher.do")) {
			String motCle=request.getParameter("motCle");
			ProduitModel model= new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits=metier.produitsParMc("%"+motCle+"%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request,response);
			
			
			
		}
		
	}
}
