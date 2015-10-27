package builders;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import webservices.XWSBanka;
import webservices.XWSBankaService;

public class XWSBankWebServiceBuilder implements WebServiceBuilder {

	private static final QName SERVICE_NAME = XWSBankaService.SERVICE;
	private static final String DEFAULT_WEBAPP_NAME = "xws-banka";
	private static String WSDL_LOCATION = "http://localhost:8080/"+DEFAULT_WEBAPP_NAME+"/services/XWSBanka?wsdl";
	private XWSBankaService service;
	
	@Override
	public Service buildWebService(String webAppName, String ipAddress) {
		
        try {
        	
        	if(webAppName!=null && !webAppName.isEmpty()) {
        		WSDL_LOCATION.replace(DEFAULT_WEBAPP_NAME, webAppName);
        	}
        	if(ipAddress!=null && !ipAddress.isEmpty()) {
        		WSDL_LOCATION.replace("localhost", ipAddress);
        	}
			URL wsdlURL = new URL(WSDL_LOCATION);
			service = new XWSBankaService(wsdlURL, SERVICE_NAME);
			
		} catch (MalformedURLException e) {
			
			throw new RuntimeException(e.getCause());
		}
        
        return service;
	}
	
	@Override
	public XWSBanka buildPort(String webAppName, String ipAddress) {
		if(service==null) {
			buildWebService(webAppName, ipAddress);
		}
		return service.getXWSBankaPort();
	}

}
