

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlReader implements stcReader {
    @Override
    public void parsee(File pathFile ) {
        try {
            File employeeXML = new File (pathFile.toURI());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = (Document) builder.parse(employeeXML);
            NodeList employeelist = doc.getElementsByTagName("emplooyee");
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            for (int i = 0; i < employeelist.getLength(); i++) {
                Node emp = employeelist.item(i);
                if (emp.getNodeType() == Node.ELEMENT_NODE) {
                    Element empElement = (Element) emp;
                    System.out.println(empElement.getAttribute("emplooyee"));
                    System.out.println(empElement.getTextContent());
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);

        }

    }
}

