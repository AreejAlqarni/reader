package com.stc;

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
import java.util.ArrayList;

public class xmlReader implements stcReader {
    @Override
    public ArrayList<unifiedFormat> parsee(File pathFile) {
        ArrayList<unifiedFormat> employeelist;
        try {
            File employeeXML = new File(pathFile.toURI());
            employeelist = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = (Document) builder.parse(employeeXML);
            Element root = doc.getDocumentElement();
            NodeList nodelist = doc.getElementsByTagName("emplooyee");
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            for (int i = 0; i < nodelist.getLength(); i++) {
                Element empElement = (Element) nodelist.item(i);
                String name = empElement.getElementsByTagName("name").item(0).getTextContent();
                int salary = Integer.parseInt(empElement.getElementsByTagName("salary").item(0).getTextContent());
                String department = empElement.getElementsByTagName("department").item(0).getTextContent();
                String gender = empElement.getElementsByTagName("gender").item(0).getTextContent();
                unifiedFormat emplooyee = new unifiedFormat(name, salary, department, gender);
                employeelist.add(emplooyee);


            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return employeelist;


    }
}

