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
import geolocalisation.dao.DoctorantDAO;
import geolocalisation.dao.ProjetDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private DoctorantDAO doctorantDAO =null;
    private ProjetDAO projetDAO=null;
	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    	projetDAO=new ProjetDAO(factory);
    } 
    
    public IndexServlet (){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    	projetDAO=new ProjetDAO(factory);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Projet> arrayProj=new ArrayList<Projet>();
        ArrayList<Doctorant> arrayDoc=new ArrayList<Doctorant>();
        arrayProj=projetDAO.dbProjet();
        if (session.getAttribute( "doctorant")==null) {
        	arrayDoc=doctorantDAO.dbDoctorant(false);
        }
        else {
        	Doctorant doctorant=(Doctorant)session.getAttribute( "doctorant");
        	request.setAttribute("doctorant",doctorant);
        	arrayDoc=doctorantDAO.dbDoctorant(true);       	
       	}
    	request.setAttribute("arrayProj",arrayProj);
    	request.setAttribute("arrayDoc",arrayDoc);
    	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }  
}