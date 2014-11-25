package beans;

/**
 *
 * @author Roger Myers
 * @since 2014/06/24
 */

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PDCount")
public class PDCount {

    private int pDCount;

    public int getpDCount() {
        return pDCount;
    }

    public void setpDCount(int pDCount) {
        this.pDCount = pDCount;
    }

    public String toStringXML() {
        String xmlCount = "";
        try {
            //http://www.vogella.com/tutorials/JAXB/article.html
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(PDCount.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            StringWriter sw = new StringWriter();
            m.marshal(this, sw);
            xmlCount = sw.toString();
            

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return xmlCount;
    }

}
