package geolocalisation.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import geolocalisation.beans.Doctorant;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.DoctorantDAO;

public class UtilisateursServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DoctorantDAO doctorantDAO=null;
	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO= new DoctorantDAO(factory);
    } 
    
    public UtilisateursServlet(){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO= new DoctorantDAO(factory);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        if (session.getAttribute( "doctorant")==null) {
        	response.sendRedirect("/geolocalisation/login");
        }
        else {
        	ArrayList<Doctorant> arrayDoc=doctorantDAO.dbDoctorant(true); 
        	if (request.getParameterMap().containsKey("ville") && request.getParameterMap().containsKey("nom")) {
        		
        	}
        	Doctorant doctorant=(Doctorant)session.getAttribute("doctorant");
        	request.setAttribute("doctorant", doctorant);
        	request.setAttribute("arrayDoc",arrayDoc);
        	this.getServletContext().getRequestDispatcher("/WEB-INF/utilisateurs.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nom = request.getParameter("nom");
        String ville = request.getParameter("ville");
        String url="/geolocalisation/utilisateurs?nom="+nom+"&ville="+ville;
        response.sendRedirect(url);
    }
}

