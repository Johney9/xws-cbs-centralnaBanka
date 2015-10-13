package delegators;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import rs.ac.uns.ftn.xws.cbs.banka_app_mapper.BankaAppMapper;
import rs.ac.uns.ftn.xws.cbs.mt900.Mt900;
import rs.ac.uns.ftn.xws.cbs.mt910.Mt910;
import webservices.XWSBanka;
import builders.XWSBankWebServiceBuilder;
import facades.DatabaseFacade;

public class BankDelegator {
	
	private static DatabaseFacade dbFacade = new DatabaseFacade();
	
	public static void sendMt900(Mt900 mt900) throws JAXBException, IOException, Exception {
    	
    	if(mt900==null) return;
    	
		String swiftDuznika = mt900.getSwiftKodBankeDuznika();
		BankaAppMapper bam = new BankaAppMapper();
		bam=dbFacade.readFromDatabase(new BankaAppMapper(), swiftDuznika);
		
		XWSBankWebServiceBuilder bwsbMt900 = new XWSBankWebServiceBuilder();
		XWSBanka bankaMt900 = bwsbMt900.buildPort(bam.getNazivAplikacije(),bam.getIpAddress());
		System.out.println("Built webservice: " +bankaMt900.toString());
		bankaMt900.primiMT900(mt900);
    }

    
    public static void sendMt910(Mt910 mt910) throws JAXBException, IOException, Exception {
    	
    	if(mt910==null) return;
    	
    	String swiftPoverioca = mt910.getSwiftKodBankePoverioca();
    	BankaAppMapper bam = new BankaAppMapper();
    	bam=dbFacade.readFromDatabase(bam, swiftPoverioca);
		
		XWSBankWebServiceBuilder bwsbMt910 = new XWSBankWebServiceBuilder();
		XWSBanka bankaMt910 = bwsbMt910.buildPort(bam.getNazivAplikacije(),bam.getIpAddress());
		
		bankaMt910.primiMT910(mt910);
    }
}
