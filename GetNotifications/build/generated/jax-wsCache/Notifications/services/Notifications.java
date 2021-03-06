
package services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Notifications", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Notifications {


    /**
     * 
     * @return
     *     returns java.util.List<services.Notification>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNotification", targetNamespace = "http://services/", className = "services.GetNotification")
    @ResponseWrapper(localName = "getNotificationResponse", targetNamespace = "http://services/", className = "services.GetNotificationResponse")
    @Action(input = "http://services/Notifications/getNotificationRequest", output = "http://services/Notifications/getNotificationResponse")
    public List<Notification> getNotification();

}
