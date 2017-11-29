package Lab5;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class DOM {
    public static void main(String[] args) {
        try {
            File incomingFile = new File("file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(incomingFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("--------------");
            for (int tmp = 0; tmp < nList.getLength(); tmp++) {
                Node nNode = nList.item(tmp);
                System.out.println("Current Element: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childs =  nNode.getChildNodes();
                    System.out.println("This book's " + nNode.getAttributes().getNamedItem("id"));
                    System.out.println("Author : " + childs.item(1).getTextContent());
                    System.out.println("Title : " + childs.item(3).getTextContent());
                    System.out.println("Genre : " + childs.item(5).getTextContent());
                    System.out.println("Price : " + childs.item(7).getTextContent());
                    System.out.println("Publish date : " + childs.item(9).getTextContent());
                    System.out.println("Description : " + childs.item(11).getTextContent() + "\n");}}
        } catch (Exception e) { e.printStackTrace(); }}}
