package hu.meiit.xpathparsegax11m;

import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XpathParseGAX11M {

	public static void main(String [] args) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new FileInputStream("studentGAX11M.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            String str = "/class/student[@rollno='593']/attribute::rollno";
            NodeList attributes = (NodeList) xPath.compile(str).evaluate(document, XPathConstants.NODESET);
            System.out.println("current element: student");
            System.out.println("student rollno: "+attributes.item(0).getNodeValue());
            str = "/class/student[@rollno='593']/child::*";
            NodeList elements = (NodeList) xPath.compile(str).evaluate(document, XPathConstants.NODESET);
            for (int i=0;i<elements.getLength();i++) {
            	System.out.print(elements.item(i).getNodeName()+": ");
            	System.out.println(elements.item(i).getFirstChild().getNodeValue());
            }
		} catch (Exception e){
        	e.getStackTrace();
        }
	}
}
