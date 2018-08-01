package geolocalisation.servlets;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import geolocalisation.beans.Doctorant;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.DoctorantDAO;
import javax.servlet.annotation.WebServlet;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DoctorantDAO doctorantDAO = null;
	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    } 
    
    public LoginServlet (){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	if (session!=null) session.invalidate();
    	this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String message="Mot de passe ou pseudo incorrecte";    
        RequestDispatcher rd = null;
        if((userName == null || userName.isEmpty()) || (password == null || password.isEmpty())){
            rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        }else{
        	String mdps = doctorantDAO.doLogin(userName);
            if(mdps.equals(password) && (!mdps.isEmpty())){
            	HttpSession session = request.getSession();
            	Doctorant doctorant = doctorantDAO.getDoctorantByUserName(userName); 
            	if(doctorant.equals(null)) {
                	request.setAttribute("message", message);
                    rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
                    rd.forward(request, response);
            	}else {
                    session.setAttribute( "doctorant", doctorant );
                    response.sendRedirect("/geolocalisation/index");
            	}
            }else {
            	request.setAttribute("message", message);
                rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
                rd.forward(request, response);
            }
        }
    }
}