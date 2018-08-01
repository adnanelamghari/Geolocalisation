package geolocalisation.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import geolocalisation.beans.Doctorant;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.DoctorantDAO;




public class RegisterServlet extends HttpServlet {
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
    
    public RegisterServlet (){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO= new DoctorantDAO(factory);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	if (session!=null) session.invalidate();
    	this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("InputPseudo");
        String passWord = request.getParameter("InputPassword1");
        String nom = request.getParameter("InputName");
        String prenom = request.getParameter("InputLastName");
        String message="Pseudo déjà utilisé";    
        RequestDispatcher rd = null;
        if((userName == null || userName.isEmpty()) || (passWord == null || passWord.isEmpty())){
            rd = request.getRequestDispatcher("/WEB-INF/register.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        }else{
        	Doctorant doctorant = doctorantDAO.getDoctorantByUserName(userName);
            if(doctorant==null){
            	doctorant =new Doctorant();
            	doctorant.setNom(nom);
            	doctorant.setPrenom(prenom);
            	doctorant.setUserName(userName);
            	doctorantDAO.addDoctorant(doctorant,passWord);
            	HttpSession session = request.getSession();            	 
                session.setAttribute( "doctorant", doctorant );
                response.sendRedirect("/geolocalisation/index");
            	}
            else {
            	request.setAttribute("message", message);
                rd = request.getRequestDispatcher("/WEB-INF/register.jsp");
                rd.forward(request, response);
            }
        }
    }
    
}

