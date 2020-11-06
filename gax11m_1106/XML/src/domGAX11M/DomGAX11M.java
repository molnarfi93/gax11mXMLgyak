package domGAX11M;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomGAX11M {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document document = db.parse("C:\\Users\\Brendi\\Documents\\gax11m_xml\\gax11m_1106\\szemelyek.xml");
			System.out.println(document.getDocumentElement().getNodeName());
			NodeList elements = document.getElementsByTagName("szemely");
			for (int i=0;i<elements.getLength();i++) {
				kiirSzemely(elements, i);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void kiirSzemely (NodeList elements, int i) {
		Element element = (Element) elements.item(i);
		System.out.println("\tid: "+element.getAttributes().item(0).getTextContent());
		System.out.println("\t\tnev: "+element.getElementsByTagName("nev").item(0).getTextContent());
		if (element.getElementsByTagName("kor").getLength() != 0) System.out.println("\t\tkor: "+element.getElementsByTagName("kor").item(0).getTextContent());
		System.out.println("\t\tvaros: "+element.getElementsByTagName("varos").item(0).getTextContent());
	}	

}
