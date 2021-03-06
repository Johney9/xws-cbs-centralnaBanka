
package rs.ac.uns.ftn.xws.cbs.centralna_banka;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import processing.states.CentralBankState;
import builders.XWSCentralBankWebServiceBuilder;
import builders.testData.Mt102TestBuilder;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-06-23T18:37:40.699+02:00
 * Generated source version: 2.6.5
 * 
 */
public final class XWSCentralnaBanka_XWSCentralnaBankaPort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.ftn.uns.ac.rs/xws/cbs/centralna_banka", "XWSCentralnaBankaService");

    private XWSCentralnaBanka_XWSCentralnaBankaPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = XWSCentralnaBankaService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        XWSCentralnaBankaService ss = new XWSCentralnaBankaService(wsdlURL, SERVICE_NAME);
        //XWSCentralnaBanka port = xws
        XWSCentralBankWebServiceBuilder wsb = new XWSCentralBankWebServiceBuilder();
        XWSCentralnaBanka port = wsb.buildPort("xws-centralna_banka","");
        System.out.println(port);
        {
        System.out.println("Invoking primiMT102...");
        rs.ac.uns.ftn.xws.cbs.mt102.Mt102 _primiMT102_mt102 = Mt102TestBuilder.buildPassTestMt102();
        port.primiMT102(_primiMT102_mt102);
        

        }
        {
        System.out.println("Invoking primiMT103...");
        rs.ac.uns.ftn.xws.cbs.mt103.Mt103 _primiMT103_mt103 = new rs.ac.uns.ftn.xws.cbs.mt103.Mt103();
        //port.primiMT103(_primiMT103_mt103);


        }

        System.exit(0);
    }

}
