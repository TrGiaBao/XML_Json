package xmldemojson;

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

public class XMLDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/xmldemojson/demo.xml"));

		document.getDocumentElement().normalize();
		Element root = document.getDocumentElement();
		NodeList nList = document.getElementsByTagName("employee");

		for (int i = 0; i < nList.getLength(); i++) {
			org.w3c.dom.Node node = nList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// Print each employee's detail
				Element eElement = (Element) node;
				Employee employee = new Employee(eElement.getAttribute("id"), 
						eElement.getElementsByTagName("firstName").item(0).getTextContent(),
						eElement.getElementsByTagName("lastName").item(0).getTextContent(),
						eElement.getElementsByTagName("location").item(0).getTextContent());
				
				System.out.println(employee);
			}
		}
	}
}
