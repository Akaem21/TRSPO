package Lab5;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
public class CreateXML {
    public static void main(String[] args) {
        getXML("Lab5");
    }
    public static File getXML(String who) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("company");
            document.appendChild(rootElement);
            Element staff = document.createElement("Staff");
            rootElement.appendChild(staff);
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);
            Element firstName = document.createElement("firstname");
            firstName.appendChild(document.createTextNode("yong"));
            staff.appendChild(firstName);
            Element lastName = document.createElement("lastName");
            lastName.appendChild(document.createTextNode("mook kim"));
            staff.appendChild(lastName);
            Element nickname = document.createElement("nickname");
            nickname.appendChild(document.createTextNode("mkyong"));
            staff.appendChild(nickname);
            Element salary = document.createElement("salary");
            salary.appendChild(document.createTextNode("100000"));
            staff.appendChild(salary);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            File xml = new File("src\\Lab5\\file" + who + ".xml");
            StreamResult result = new StreamResult(xml);
            transformer.transform(source, result);
            System.out.println("File saved!");
            return xml;
        } catch (ParserConfigurationException | TransformerException e) {
            return null;}}}
