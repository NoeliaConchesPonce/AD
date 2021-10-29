package es.florida.AE3;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio2 {
	
 
	    public static void main(String[] args) throws ParserConfigurationException, SAXException 
	    { 
	        try {
	            File file = new File("Hola.xml");
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document document = db.parse(file);
	            document.getDocumentElement().normalize();
	            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
	            NodeList nList = document.getElementsByTagName("movil");
	            System.out.println("----------------------------");
	            for (int temp = 0; temp < nList.getLength(); temp++) {
	                Node nNode = nList.item(temp);
	                System.out.println("\nCurrent Element :" + nNode.getNodeName());
	                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                    Element eElement = (Element) nNode;
	                    System.out.println("movil id : " + eElement.getAttribute("id"));
	                    System.out.println("Marca : " + eElement.getElementsByTagName("marca").item(0).getTextContent());
	                    System.out.println("Modelo : " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
	                    System.out.println("RAM : " + eElement.getElementsByTagName("RAM").item(0).getTextContent());
	                    System.out.println("Sistema : " + eElement.getElementsByTagName("sistema").item(0).getTextContent());

	                }
	            }
	        }
	        catch(IOException e) {
	            System.out.println(e);
	        } 
	    }
	
}
