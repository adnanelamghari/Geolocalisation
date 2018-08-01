package geolocalisation.servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import geolocalisation.beans.Diplome;
import geolocalisation.beans.Doctorant;
import geolocalisation.beans.Projet;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.DiplomeDAO;
import geolocalisation.dao.DoctorantDAO;
import geolocalisation.dao.ProjetDAO;


public class ProfileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    ProjetDAO projetDAO=null;
    DoctorantDAO doctorantDAO=null;
    DiplomeDAO diplomeDAO=null;
	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    	diplomeDAO=new DiplomeDAO(factory);
    	projetDAO=new ProjetDAO(factory);
    } 
    
    public ProfileServlet(){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    	diplomeDAO=new DiplomeDAO(factory);
    	projetDAO=new ProjetDAO(factory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Projet> arrayProj=new ArrayList<Projet>();
        ArrayList<Diplome> arrayDip=new ArrayList<Diplome>();
        Doctorant doctorant =new Doctorant();
        String doc=request.getParameter("doctorant");
        if (doc==null || doc.equals("")) {
            if (session.getAttribute( "doctorant")==null && doctorantDAO.getDoctorantByUserName(doc).getEnumProfile().equals("0")) {
            	response.sendRedirect("/geolocalisation/login");
            }
            else {          	
                String diplome=request.getParameter("diplome");
                if ((diplome!=null) && (!diplome.equals(""))) {
                    diplomeDAO.deleteDiplome(Integer.valueOf(diplome));
                }
            	doctorant=(Doctorant)session.getAttribute("doctorant");
            }
        }
        else {
        	doctorant=doctorantDAO.getDoctorantByUserName(doc);
            if (doctorant.getEnumProfile().equals("-1")){ //si profile privé
                response.sendRedirect("/geolocalisation/index");
            }
        }
        arrayProj=projetDAO.getListeProjetDoctorant(doctorant.getUserName());
        arrayDip=diplomeDAO.getListeDiplomeDoctorant(doctorant.getUserName());
        if (doctorant.getEnumProjet().equals("-1")&&session.getAttribute("doctorant")!=null){ //si les projets sont cachés
            if (! (((Doctorant)session.getAttribute("doctorant")).getUserName()).equals(doctorant.getUserName())){
                arrayProj=null;
            }
        }
        else if(doctorant.getEnumProjet().equals("-1")){ //si les projets sont cachés
            arrayProj=null;
        }
        request.setAttribute("arrayProj",arrayProj);
        request.setAttribute("arrayDip",arrayDip);
    	request.setAttribute("doctorant",doctorant);
    	this.getServletContext().getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);
    }  
    
}
