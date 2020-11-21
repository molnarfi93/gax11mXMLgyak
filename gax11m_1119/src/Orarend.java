import java.io.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Orarend {

	public static void main(String[] args) {
		try {
			TransformerFactory tf = TransformerFactory.newInstance("org.apache.xalan.processor.TransformerFactoryImpl", null);
			Transformer xsl = tf.newTransformer(new StreamSource(new File("orarendGAX11M.xsl")));
			StreamSource xml = new StreamSource(new File("orarendGAX11M.xml"));
			StreamResult xmlout = new StreamResult(new File("orarendGAX11M.out.xml"));
			xsl.transform(xml, xmlout);
			StreamResult html = new StreamResult(new File("orarendGAX11M.html"));
			xsl.transform(xml, html);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
