import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.time.LocalDate;

public class DOMWriter {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			Document document = db.parse("adatbazis.xml");
			Element root = document.getDocumentElement();
			System.out.println(root.getNodeName());
			NodeList entities = root.getChildNodes();
			for (int i=0;i<entities.getLength();i++) {
				//életkorok származtatása//
				if (entities.item(i).getNodeName().equals("macska") || entities.item(i).getNodeName().equals("ember")) {
					try {
						String szuletesnap = ((Element) ((Element) entities.item(i)).getElementsByTagName("szul_adatok").item(0)).getElementsByTagName("szuletesnap").item(0).getTextContent();
						String[] komponensek = szuletesnap.split("/");
						int szul_ev = Integer.parseInt(komponensek[2]);
						int jelenlegi_ev = LocalDate.now().getYear();
						String eletkor = String.valueOf(jelenlegi_ev - szul_ev);
						NodeList nodes = ((Element) entities.item(i)).getElementsByTagName("eletkor");
						nodes.item(0).setTextContent(eletkor);
					} catch (ArrayIndexOutOfBoundsException e) {
					}
					
				}
				//törlés//
				if (entities.item(i).getNodeName().equals("ember")) {
					if (((Element) entities.item(i)).getAttributeNode("szig_szam").getTextContent().equals("999989SA")) {
						root.removeChild(entities.item(i));	
				    } else {
				    	NodeList nodes = ((Element) entities.item(i)).getElementsByTagName("lakhely");
				    	entities.item(i).removeChild(nodes.item(0));
					}
				}	
				//macska elem(attribútum) létrehozása az emberekhez//
				if (entities.item(i).getNodeName().equals("ember")) {
					for (int j=0;j<entities.getLength();j++) {
						if (entities.item(j).getNodeName().equals("macska") && ((Element) entities.item(j)).getAttributeNode("gazda").getTextContent().equals(((Element) entities.item(i)).getAttributeNode("szig_szam").getTextContent())) {
						    Element macska = document.createElement("macska");
							NodeList nodes = ((Element) entities.item(j)).getElementsByTagName("nev");
							macska.setTextContent(nodes.item(0).getTextContent());
							entities.item(i).appendChild(macska);
						}
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
