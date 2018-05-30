
package cornflower.twf.soap.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TextbooksService", targetNamespace = "http://soap.twf.cornflower/", wsdlLocation = "http://localhost:8080/textbooks-with-friends/TextbooksService?wsdl")
public class TextbooksService_Service
    extends Service
{

    private final static URL TEXTBOOKSSERVICE_WSDL_LOCATION;
    private final static WebServiceException TEXTBOOKSSERVICE_EXCEPTION;
    private final static QName TEXTBOOKSSERVICE_QNAME = new QName("http://soap.twf.cornflower/", "TextbooksService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/textbooks-with-friends/TextbooksService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TEXTBOOKSSERVICE_WSDL_LOCATION = url;
        TEXTBOOKSSERVICE_EXCEPTION = e;
    }

    public TextbooksService_Service() {
        super(__getWsdlLocation(), TEXTBOOKSSERVICE_QNAME);
    }

    public TextbooksService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), TEXTBOOKSSERVICE_QNAME, features);
    }

    public TextbooksService_Service(URL wsdlLocation) {
        super(wsdlLocation, TEXTBOOKSSERVICE_QNAME);
    }

    public TextbooksService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TEXTBOOKSSERVICE_QNAME, features);
    }

    public TextbooksService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TextbooksService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TextbooksService
     */
    @WebEndpoint(name = "TextbooksServicePort")
    public TextbooksService getTextbooksServicePort() {
        return super.getPort(new QName("http://soap.twf.cornflower/", "TextbooksServicePort"), TextbooksService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TextbooksService
     */
    @WebEndpoint(name = "TextbooksServicePort")
    public TextbooksService getTextbooksServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.twf.cornflower/", "TextbooksServicePort"), TextbooksService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TEXTBOOKSSERVICE_EXCEPTION!= null) {
            throw TEXTBOOKSSERVICE_EXCEPTION;
        }
        return TEXTBOOKSSERVICE_WSDL_LOCATION;
    }

}