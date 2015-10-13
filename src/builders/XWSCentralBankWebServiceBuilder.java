package builders;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import rs.ac.uns.ftn.xws.cbs.centralna_banka.XWSCentralnaBanka;
import rs.ac.uns.ftn.xws.cbs.centralna_banka.XWSCentralnaBankaService;

public class XWSCentralBankWebServiceBuilder implements WebServiceBuilder {

	private static final QName SERVICE_NAME = XWSCentralnaBankaService.SERVICE;
	private static final String DEFAULT_WEBAPP_NAME = "xws-centralna_banka";
	private static String WSDL_LOCATION = "http://localhost:8080/"+DEFAULT_WEBAPP_NAME+"/services/XWSCentralnaBanka?wsdl";
	private XWSCentralnaBankaService service;
	
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
			service = new XWSCentralnaBankaService(wsdlURL, SERVICE_NAME);
			
		} catch (MalformedURLException e) {
			
			throw new RuntimeException(e.getCause());
		}
        
        return service;
	}
	
	
	@Override
	public XWSCentralnaBanka buildPort(String webAppName, String ipAddress) {
		if(service==null) {
			buildWebService(webAppName, ipAddress);
		}
		return service.getXWSCentralnaBankaPort();
	}
	

}
