package delegators;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import rs.ac.uns.ftn.xws.cbs.banka_app_mapper.BankaAppMapper;
import rs.ac.uns.ftn.xws.cbs.mt900.Mt900;
import rs.ac.uns.ftn.xws.cbs.mt910.Mt910;
import utility.MtCoupler;
import webservices.Banka;
import builders.BankWebServiceBuilder;
import facades.DatabaseFacade;

public class BankDelegator {
	
	private static DatabaseFacade dbFacade = new DatabaseFacade();
	
	public static void sendMt900(MtCoupler mtc) throws JAXBException, IOException, Exception {
    	
    	Mt900 mt900 = mtc.getMt900();
		
		String swiftDuznika = mt900.getSwiftKodBankeDuznika();
		BankaAppMapper bam = null;
		bam=dbFacade.readFromDatabase(bam, swiftDuznika);
		
		BankWebServiceBuilder bwsbMt900 = new BankWebServiceBuilder();
		Banka bankaMt900 = bwsbMt900.buildPort(bam.getNazivAplikacije());
		   
		bankaMt900.primiMT900(mt900);
    }

    
    public static void sendMt910(MtCoupler mtc) throws JAXBException, IOException, Exception {
    	
    	Mt910 mt910 = mtc.getMt910();
    	
    	String swiftPoverioca = mt910.getSwiftKodBankePoverioca();
    	BankaAppMapper bam = null;
    	bam=dbFacade.readFromDatabase(bam, swiftPoverioca);
		
		BankWebServiceBuilder bwsbMt910 = new BankWebServiceBuilder();
		Banka bankaMt910 = bwsbMt910.buildPort(bam.getNazivAplikacije());
		
		bankaMt910.primiMT910(mt910);
    }
}
