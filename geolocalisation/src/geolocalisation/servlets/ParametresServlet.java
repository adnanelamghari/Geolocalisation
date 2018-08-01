package geolocalisation.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.Part;
import geolocalisation.beans.Diplome;
import geolocalisation.beans.Doctorant;
import geolocalisation.dao.DAOFactory;
import geolocalisation.dao.DiplomeDAO;
import geolocalisation.dao.DoctorantDAO;



public class ParametresServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIERS = "./profil_pics/";
    private DoctorantDAO doctorantDAO=null;
    private DiplomeDAO diplomeDAO=null;

	@Override 
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    	diplomeDAO=new DiplomeDAO(factory);
    } 
    
    public ParametresServlet (){
    	super();
    	DAOFactory factory =new DAOFactory();
    	doctorantDAO=new DoctorantDAO(factory);
    	diplomeDAO=new DiplomeDAO(factory);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute( "doctorant")==null) {
        	response.sendRedirect("/geolocalisation/login");
        }
        else {
        	Doctorant doctorant=(Doctorant)session.getAttribute("doctorant");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2= new SimpleDateFormat("dd/MM/yyyy");
            Date parsed=null;
    		try {
    			parsed = format.parse(doctorant.getDateNaissance().toString());
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
            java.util.Date datedenaissance = new java.util.Date(parsed.getTime());            
            request.setAttribute("dateNaissance", format2.format(datedenaissance));
        	request.setAttribute("doctorant", doctorant);
        	this.getServletContext().getRequestDispatcher("/WEB-INF/parametres.jsp").forward(request, response);     	
       	}        
    } 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String inputPseudo = ((Doctorant)session.getAttribute("doctorant")).getUserName();
        String inputPasswordOld = request.getParameter("InputPassword-old");
        String inputPasswordNew1 = request.getParameter("InputPasswordNew1");
        String inputPasswordNew2 = request.getParameter("InputPasswordNew2");
        String inputIntitule = request.getParameter("InputIntitule");
        String inputLieu = request.getParameter("InputLieu");
        String dateDebut = request.getParameter("date1");
        String dateFin = request.getParameter("dateFin");
        String inputPhoneNumber = request.getParameter("InputPhoneNumber");
        String mail = request.getParameter("mail");
        String urlLinkedIn = request.getParameter("UrlLinkedIn");
        String urlFacebook = request.getParameter("UrlFacebook");
        String biographie = request.getParameter("Biographie");
        String inputName = request.getParameter("InputName");
        String inputLastName = request.getParameter("InputLastName");
        String dateInput = request.getParameter("date");          
        String desactivation = request.getParameter("desctivation");
        String recherchePRVICY = request.getParameter("RecherchePRVICY");
        String profilePRVICY = request.getParameter("profilePRVICY");
        String msgPRVICY = request.getParameter("msgPRVICY"); 
        Doctorant doctorant = null;
        Part part = request.getPart("userfilel");
        String nomFichier = getNomFichier(part);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed=null;
        java.sql.Date datedenaissance=null;
        if ((!dateInput.equals(""))&&(!dateInput.isEmpty())) {
    		try {
    			parsed = format.parse(dateInput);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
            datedenaissance = new java.sql.Date(parsed.getTime());
        }
	    doctorant = new  Doctorant(inputPseudo, inputName, inputLastName, mail, datedenaissance, urlFacebook,
        		urlLinkedIn, biographie, inputPhoneNumber, msgPRVICY, recherchePRVICY,
        		profilePRVICY); 
        if (nomFichier != null && !nomFichier.isEmpty()) {
             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                    .substring(nomFichier.lastIndexOf('\\') + 1);
            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
        }
        if ((!inputIntitule.isEmpty())&&(inputIntitule!=null)&&(!inputLieu.isEmpty())&&(inputLieu!=null)) {
        	Diplome diplome =new Diplome(inputIntitule,inputLieu, dateDebut, dateFin, inputPseudo); 
        	diplomeDAO.addDiplome(diplome);
    	}        
        String oldPassWord=doctorantDAO.doLogin(inputPseudo);
        if((!inputPasswordNew1.isEmpty()) && (inputPasswordNew1.equals(inputPasswordNew2)) && (oldPassWord.equals(inputPasswordOld))){ 
        	doctorantDAO.updatePassWordDoctorant(doctorant, inputPasswordNew1);
        	doctorantDAO.updateDoctorant(doctorant);
        }else{
        	doctorantDAO.updateDoctorant(doctorant);
        }
        if (desactivation.equals("true")) {
        	doctorantDAO.deleteDoctorant(doctorant);
        	response.sendRedirect("/geolocalisation/index");
        }
        session.removeAttribute( "doctorant");
        session.setAttribute( "doctorant", doctorant);
        response.sendRedirect("/geolocalisation/profile");
    }
    
    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }
    
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }   
}
