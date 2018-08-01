package geolocalisation.servlets;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import geolocalisation.beans.Doctorant;
import geolocalisation.beans.Message;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.DoctorantDAO;


public class ChatServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DoctorantDAO doctorantDAO=null;
	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    } 
    
    public ChatServlet (){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    }    
	ArrayList<Message> msgs = new ArrayList<Message>();
	String msg;
	String author;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		HttpSession session = req.getSession();
		String name=((Doctorant)session.getAttribute("doctorant")).getNom();
		Doctorant doctorant = (Doctorant)session.getAttribute("doctorant");
		Doctorant doctoranta=null;
        String doctorantUserName=req.getParameter("doctorant");
        if ((doctorantUserName!=null) && (!doctorantUserName.equals(""))) {
        	doctoranta=doctorantDAO.getDoctorantByUserName(doctorantUserName);
        	 req.setAttribute("doctoranta", doctoranta);
        }       
        req.setAttribute("doctorant", doctorant);
		req.setAttribute("author", name);
		req.getRequestDispatcher("WEB-INF/chat.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ChatServlat.doPost()");
		resp.setCharacterEncoding("utf-8");
		// si la requete contient l'attribut "refresh"
		if(req.getParameter("refresh")!=null){
			int num = Integer.parseInt(req.getParameter("refresh"));
			//on parcours le array
			if(num < msgs.size() ){
				String author,content;
				for (int i = num; i < msgs.size(); i++) {
					 author = ((Message) msgs.get(i)).getPseudoEmeteur();
					 content = ((Message) msgs.get(i)).getTextMessage();
					 content = content.replace("\n", "");
					 resp.getWriter().write("{\"author\":\""+author+"\",\"content\":\""+content+"\"}+");
				}
			}
		}else{
			msg = req.getParameter("msg");
			author = req.getParameter("author");
			// création de l'objet message
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");// 
			DateFormat heurFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			msgs.add(new Message(author,"adnane", msg, dateFormat.format(date).toString(), heurFormat.format(date).toString()));
			resp.getWriter().write(author+"+"+msg+"+"+ msgs.size());	
		}
	}
}