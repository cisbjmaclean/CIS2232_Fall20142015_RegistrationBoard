
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

    private final static QName _GetNotification_QNAME = new QName("http://services/", "getNotification");
    private final static QName _GetNotificationResponse_QNAME = new QName("http://services/", "getNotificationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNotificationResponse }
     * 
     */
    public GetNotificationResponse createGetNotificationResponse() {
        return new GetNotificationResponse();
    }

    /**
     * Create an instance of {@link GetNotification }
     * 
     */
    public GetNotification createGetNotification() {
        return new GetNotification();
    }

    /**
     * Create an instance of {@link Notification }
     * 
     */
    public Notification createNotification() {
        return new Notification();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getNotification")
    public JAXBElement<GetNotification> createGetNotification(GetNotification value) {
        return new JAXBElement<GetNotification>(_GetNotification_QNAME, GetNotification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getNotificationResponse")
    public JAXBElement<GetNotificationResponse> createGetNotificationResponse(GetNotificationResponse value) {
        return new JAXBElement<GetNotificationResponse>(_GetNotificationResponse_QNAME, GetNotificationResponse.class, null, value);
    }

}
