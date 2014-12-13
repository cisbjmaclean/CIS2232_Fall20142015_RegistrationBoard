
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
    private final static QName _Getname_QNAME = new QName("http://services/", "getname");
    private final static QName _GetnameResponse_QNAME = new QName("http://services/", "getnameResponse");
    private final static QName _ActiveEmails_QNAME = new QName("http://services/", "activeEmails");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Getname }
     * 
     */
    public Getname createGetname() {
        return new Getname();
    }

    /**
     * Create an instance of {@link GetnameResponse }
     * 
     */
    public GetnameResponse createGetnameResponse() {
        return new GetnameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "activeEmailsResponse")
    public JAXBElement<GetnameResponse> createActiveEmailsResponse(GetnameResponse value) {
        return new JAXBElement<GetnameResponse>(_ActiveEmailsResponse_QNAME, GetnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getname")
    public JAXBElement<Getname> createGetname(Getname value) {
        return new JAXBElement<Getname>(_Getname_QNAME, Getname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getnameResponse")
    public JAXBElement<GetnameResponse> createGetnameResponse(GetnameResponse value) {
        return new JAXBElement<GetnameResponse>(_GetnameResponse_QNAME, GetnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "activeEmails")
    public JAXBElement<Getname> createActiveEmails(Getname value) {
        return new JAXBElement<Getname>(_ActiveEmails_QNAME, Getname.class, null, value);
    }

}
