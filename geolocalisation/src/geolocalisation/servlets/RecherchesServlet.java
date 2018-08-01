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
import geolocalisation.beans.Projet;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.ProjetDAO;

public class RecherchesServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Doctorant doctorant;
    ProjetDAO projetDAO=null;
	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	projetDAO=new ProjetDAO(factory);
    } 
    
    public RecherchesServlet(){
    	super();
    	DAOFactory factory =new DAOFactory();
    	projetDAO=new ProjetDAO(factory);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        if (session.getAttribute( "doctorant")==null) {
        	response.sendRedirect("/geolocalisation/login");
        }
        else {
            String projet=request.getParameter("projet");
            if ((projet!=null) && (!projet.equals(""))) {
                projetDAO.deleteProjet(Integer.valueOf(projet));
            }
        	String id_doc= ((Doctorant)session.getAttribute( "doctorant")).getUserName();
        	ArrayList<Projet> arrayProj= projetDAO.getListeProjetDoctorant(id_doc);
        	request.setAttribute("arrayProj",arrayProj);
        	doctorant=(Doctorant)session.getAttribute("doctorant");
        	request.setAttribute("doctorant", doctorant);
        	this.getServletContext().getRequestDispatcher("/WEB-INF/recherches.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String titre = request.getParameter("Titre");
        String description = request.getParameter("Description");
        String ecole = request.getParameter("Ecole");
        String discipline= request.getParameter("Discipline");
        String laboratoire = request.getParameter("Laboratoire");
        Double longitude= Double.parseDouble(request.getParameter("longitude"));        
        Double latitude = Double.parseDouble(request.getParameter("Latitude"));
        HttpSession session = request.getSession(false);        
        String id_doc= ((Doctorant)session.getAttribute( "doctorant")).getUserName();
        Projet projet=new Projet(titre, description, id_doc, ecole, discipline, laboratoire,latitude,longitude );
        projetDAO.addProjet(projet);
        response.sendRedirect("/geolocalisation/recherches");
    }
}
