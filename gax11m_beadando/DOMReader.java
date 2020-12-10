import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMReader {

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
				if (entities.item(i).getNodeName().equals("macska")) kiirMacska(entities, i);
				else if (entities.item(i).getNodeName().equals("ember")) kiirEmber(entities, i);
				else if (entities.item(i).getNodeName().equals("varos")) kiirVaros(entities, i);
				else if (entities.item(i).getNodeName().equals("orszag")) kiirOrszag(entities, i);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void kiirMacska (NodeList entities, int i) {
		System.out.println("\tmacska");
		Element entity = (Element) entities.item(i);
		String gazda = entity.getAttributeNode("gazda").getTextContent();
		for (int j=0;j<entities.getLength();j++) {
			if (entities.item(j).getNodeName().equals("ember") && ((Element) entities.item(j)).getAttributeNode("szig_szam").getTextContent().equals(gazda)) {
				System.out.print("\t\tgazda: "+((Element) entities.item(j)).getElementsByTagName("nev").item(0).getTextContent());
				System.out.println(" ("+gazda+")");
				break;
			}
		}
		System.out.println("\t\tnév: "+entity.getElementsByTagName("nev").item(0).getTextContent());
		System.out.println("\t\tfajta: "+entity.getElementsByTagName("fajta").item(0).getTextContent());
		System.out.println("\t\tszül. adatok: ");
		Element szul_adatok = (Element) entity.getElementsByTagName("szul_adatok").item(0);
		String varos = szul_adatok.getAttributeNode("szul_hely").getTextContent();
		for (int j=0;j<entities.getLength();j++) {
			if (entities.item(j).getNodeName().equals("varos") && ((Element) entities.item(j)).getAttributeNode("iranyitoszam").getTextContent().equals(varos)) {
				System.out.print("\t\t\tszül. hely: "+((Element) entities.item(j)).getElementsByTagName("nev").item(0).getTextContent());
				System.out.println(" ("+varos+")");
				break;
			}
		}	
		System.out.println("\t\t\tszületésnap: "+szul_adatok.getElementsByTagName("szuletesnap").item(0).getTextContent());
		System.out.println("\t\téletkor: "+entity.getElementsByTagName("eletkor").item(0).getTextContent());
		System.out.println("\t\tnem: "+entity.getElementsByTagName("nem").item(0).getTextContent());
	}
	
	public static void kiirEmber (NodeList entities, int i) {
		System.out.println("\tember");
		Element entity = (Element) entities.item(i);
		System.out.println("\t\tszig. szám: "+entity.getAttributeNode("szig_szam").getTextContent());
		System.out.println("\t\tnév: "+entity.getElementsByTagName("nev").item(0).getTextContent());
		System.out.println("\t\tszül. adatok: ");
		Element szul_adatok = (Element) entity.getElementsByTagName("szul_adatok").item(0);
		String szul_varos = szul_adatok.getAttributeNode("szul_hely").getTextContent();
		for (int j=0;j<entities.getLength();j++) {
			if (entities.item(j).getNodeName().equals("varos") && ((Element) entities.item(j)).getAttributeNode("iranyitoszam").getTextContent().equals(szul_varos)) {
				System.out.print("\t\t\tszül. hely: "+((Element) entities.item(j)).getElementsByTagName("nev").item(0).getTextContent());
				System.out.println(" ("+szul_varos+")");
				break;
			}
		}	
		System.out.println("\t\t\tszületésnap: "+szul_adatok.getElementsByTagName("szuletesnap").item(0).getTextContent());
		System.out.println("\t\téletkor: "+entity.getElementsByTagName("eletkor").item(0).getTextContent());
		try {
			System.out.println("\t\tlakhely: ");
			Element lakhely = (Element) entity.getElementsByTagName("lakhely").item(0);
			String lakhely_varos = lakhely.getAttributeNode("varos").getTextContent();
			for (int j=0;j<entities.getLength();j++) {
				if (entities.item(j).getNodeName().equals("varos") && ((Element) entities.item(j)).getAttributeNode("iranyitoszam").getTextContent().equals(lakhely_varos)) {
					System.out.print("\t\t\tváros: "+((Element) entities.item(j)).getElementsByTagName("nev").item(0).getTextContent());
					System.out.println(" ("+lakhely_varos+")");
					System.out.println("\t\t\tút, házszám: "+lakhely.getElementsByTagName("ut_hazszam").item(0).getTextContent());
					break;
				}
			}
		} catch (NullPointerException e) {
		}	
		try {
			NodeList nodes = entity.getElementsByTagName("macska");
			System.out.println("\t\tmacska: "+nodes.item(0).getTextContent());
		} catch (NullPointerException e) {		
		}
	}
	
	public static void kiirVaros (NodeList entities, int i) {
		System.out.println("\tváros");
		Element entity = (Element) entities.item(i);
		System.out.println("\t\tirányítószám: "+entity.getAttributeNode("iranyitoszam").getTextContent());
		System.out.println("\t\tnév: "+entity.getElementsByTagName("nev").item(0).getTextContent());
		System.out.println("\t\tország: "+entity.getAttributes().item(1).getTextContent());
		System.out.println("\t\tnépesség: "+entity.getElementsByTagName("nepesseg").item(0).getTextContent());
		System.out.println("\t\tterület: "+entity.getElementsByTagName("terulet").item(0).getTextContent());
		System.out.println("\t\ttestvérvárosok: ");
		for (int j=0;j<entities.getLength();j++) {
			if (entities.item(j).getNodeName().equals("testvervarosok")) {
				if (((Element) entities.item(j)).getAttributeNode("iszam1").getTextContent().equals(entity.getAttributeNode("iranyitoszam").getTextContent())) {
					for (int k=0;k<entities.getLength();k++) {
						if (entities.item(k).getNodeName().equals("varos") && ((Element) entities.item(k)).getAttributeNode("iranyitoszam").getTextContent().equals(((Element) entities.item(j)).getAttributeNode("iszam2").getTextContent())) {
							System.out.print("\t\t\t"+((Element) entities.item(k)).getElementsByTagName("nev").item(0).getTextContent());
							System.out.println(" ("+((Element) entities.item(k)).getAttributeNode("iranyitoszam").getTextContent()+")");
							break;
						}
					}
				}
				else if (((Element) entities.item(j)).getAttributeNode("iszam2").getTextContent().equals(entity.getAttributeNode("iranyitoszam").getTextContent())) {
					for (int k=0;k<entities.getLength();k++) {
						if (entities.item(k).getNodeName().equals("varos") && ((Element) entities.item(k)).getAttributeNode("iranyitoszam").getTextContent().equals(((Element) entities.item(j)).getAttributeNode("iszam1").getTextContent())) {
							System.out.print("\t\t\t"+((Element) entities.item(k)).getElementsByTagName("nev").item(0).getTextContent());
							System.out.println(" ("+((Element) entities.item(k)).getAttributeNode("iranyitoszam").getTextContent()+")");
							break;
						}
					}
				}
			}
		}	
	}
	
	public static void kiirOrszag (NodeList entities, int i) {
		System.out.println("\tország");
		Element entity = (Element) entities.item(i);
		System.out.println("\t\tnév: "+entity.getAttributeNode("nev").getTextContent());
		String fovaros = entity.getAttributeNode("fovaros").getTextContent();
		for (int j=0;j<entities.getLength();j++) {
			if (entities.item(j).getNodeName().equals("varos") && ((Element) entities.item(j)).getAttributeNode("iranyitoszam").getTextContent().equals(fovaros)) {
				System.out.print("\t\tfőváros: "+((Element) entities.item(j)).getElementsByTagName("nev").item(0).getTextContent());
				System.out.println(" ("+fovaros+")");
				break;
			}
		}
		String legn_varos = entity.getAttributeNode("legn_varos").getTextContent();
		for (int j=0;j<entities.getLength();j++) {
			if (entities.item(j).getNodeName().equals("varos") && ((Element) entities.item(j)).getAttributeNode("iranyitoszam").getTextContent().equals(legn_varos)) {
				System.out.print("\t\tlegn. város: "+((Element) entities.item(j)).getElementsByTagName("nev").item(0).getTextContent());
				System.out.println(" ("+legn_varos+")");
				break;
			}
		}
		System.out.println("\t\tnépesség: "+entity.getElementsByTagName("nepesseg").item(0).getTextContent());
		System.out.println("\t\terület: "+entity.getElementsByTagName("terulet").item(0).getTextContent());
		System.out.println("\t\tvaluta: "+entity.getElementsByTagName("valuta").item(0).getTextContent());
	}
	
}
