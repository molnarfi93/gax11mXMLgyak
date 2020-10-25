package saxGAX11M;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import oracle.jdbc.driver.*;
import org.xml.sax.*;
import GAX11M_XML.cats.xml;

public class SaxGAX11M implements ContentHandler{

	public static void main(String[] args) {
		try {
			XMLReader parser = new SAXParser();
			SaxGAX11M handler = new SaxGAX11M();
			parser.setContentHandler(handler);
			if (args.length  > 0) parser.parse(args[0]);
			else parser.parse("cats.xml");
		} catch (SAXException e) {
		    System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException{
		if (localName.compareTo("cat") == 0) System.out.println("start");
		else if (localName.compareTo("name") == 0) System.out.println("start");
		else if (localName.compareTo("age") == 0) System.out.println("start");
		else if (localName.compareTo("breed") == 0) System.out.println("start");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		System.out.println("end");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		if(length == 0) return;
		int end = (start + length) - 1;
		StringBuffer contentBuffer = new StringBuffer();
		while (ch[start] <= '\u0020') {
		    if (start == end) return;
		    start++;
		    length--;
	    }
		while (ch[end] <= '\u0020') {
		    if (end == start) return;
		    length--;
		    end--;
	    }
		contentBuffer.append(ch, start, length);
		if ("name".equals("id")) System.out.println("{id:"+contentBuffer.toString()+"}");
		else System.out.println(contentBuffer.toString());
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}	

}
