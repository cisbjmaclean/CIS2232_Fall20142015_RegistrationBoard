
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

    private final static QName _GetMemberEd_QNAME = new QName("http://services/", "getMemberEd");
    private final static QName _GetMemberEdResponse_QNAME = new QName("http://services/", "getMemberEdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMemberEdResponse }
     * 
     */
    public GetMemberEdResponse createGetMemberEdResponse() {
        return new GetMemberEdResponse();
    }

    /**
     * Create an instance of {@link GetMemberEd }
     * 
     */
    public GetMemberEd createGetMemberEd() {
        return new GetMemberEd();
    }

    /**
     * Create an instance of {@link MemberEducation }
     * 
     */
    public MemberEducation createMemberEducation() {
        return new MemberEducation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMemberEd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getMemberEd")
    public JAXBElement<GetMemberEd> createGetMemberEd(GetMemberEd value) {
        return new JAXBElement<GetMemberEd>(_GetMemberEd_QNAME, GetMemberEd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMemberEdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getMemberEdResponse")
    public JAXBElement<GetMemberEdResponse> createGetMemberEdResponse(GetMemberEdResponse value) {
        return new JAXBElement<GetMemberEdResponse>(_GetMemberEdResponse_QNAME, GetMemberEdResponse.class, null, value);
    }

}
