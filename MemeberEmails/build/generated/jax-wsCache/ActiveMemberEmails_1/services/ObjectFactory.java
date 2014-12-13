
package services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ActiveEmailsResponse_QNAME = new QName("http://services/", "activeEmailsResponse");
    private final static QName _ActiveEmails_QNAME = new QName("http://services/", "activeEmails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActiveEmails }
     * 
     */
    public ActiveEmails createActiveEmails() {
        return new ActiveEmails();
    }

    /**
     * Create an instance of {@link ActiveEmailsResponse }
     * 
     */
    public ActiveEmailsResponse createActiveEmailsResponse() {
        return new ActiveEmailsResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActiveEmailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "activeEmailsResponse")
    public JAXBElement<ActiveEmailsResponse> createActiveEmailsResponse(ActiveEmailsResponse value) {
        return new JAXBElement<ActiveEmailsResponse>(_ActiveEmailsResponse_QNAME, ActiveEmailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActiveEmails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "activeEmails")
    public JAXBElement<ActiveEmails> createActiveEmails(ActiveEmails value) {
        return new JAXBElement<ActiveEmails>(_ActiveEmails_QNAME, ActiveEmails.class, null, value);
    }

}
