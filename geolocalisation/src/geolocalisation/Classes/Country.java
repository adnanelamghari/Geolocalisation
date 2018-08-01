package geolocalisation.Classes;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Country {
	@SuppressWarnings("finally")
	public String findCountry(Double lat, Double lng) throws IOException {
		String country="";
    	String url="http://ws.geonames.org/findNearbyPlaceName?lat="+String.valueOf(lat)+"&lng="+String.valueOf(lng)+"&username=adnane.lamghari";
    	InputStream is = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String xmlText = readAll(rd);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document;
        try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource(new StringReader(xmlText)));
			Element racine = document.getDocumentElement();
			NodeList noderacine =racine.getChildNodes();
			country=(((Element) noderacine).getElementsByTagName("countryName").item(0)).getTextContent();	
        } catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (org.xml.sax.SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
        	return country;
        }
	}
	
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
      }
}
