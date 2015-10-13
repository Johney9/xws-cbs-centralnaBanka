package test;

import static org.junit.Assert.fail;

import java.awt.image.BandedSampleModel;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.xml.sax.SAXException;

import delegators.BankDelegator;
import builders.central_bank.Mt900Builder;
import builders.central_bank.Mt910Builder;
import builders.testData.Mt102TestBuilder;
import rs.ac.uns.ftn.xws.cbs.mt102.Mt102;
import rs.ac.uns.ftn.xws.cbs.mt900.Mt900;
import rs.ac.uns.ftn.xws.cbs.mt910.Mt910;
import singleton.MainCentralBankProcessor;
import utility.MtCoupler;

public class MainCentralBankProcessorTest {

	MainCentralBankProcessor mcb = MainCentralBankProcessor.getInstance();
	
	@Test
	public void testProcessMt102() throws JAXBException, IOException, SAXException, Exception {
		Mt102 mt102 = Mt102TestBuilder.buildPassTestMt102();
		mcb.process(mt102);
	}

	//@Test
	public void testResolveMt102s() {
		fail("Not yet implemented");
	}

	//@Test
	public void testRetrieveFromDB() {
		fail("Not yet implemented");
	}

	/*
	@Test
	public void testBuildMtc() {
		Mt102 mt102 = Mt102TestBuilder.buildTestMt102();
		Mt910 mt910 = Mt910Builder.buildMt910(mt102);
		//build an mt900
		Mt900 mt900 = Mt900Builder.buildMt900(mt102);
		System.out.println(mt910.getIdPoruke()+" iznos:"+mt910.getIznos());
		System.out.println(mt900.getIdPoruke()+" iznos:"+mt900.getIznos());
	}

	@Test
	public void testDelegateToBanks() throws JAXBException, IOException, Exception {
		Mt102 mt102 = Mt102TestBuilder.buildTestMt102();
		Mt910 mt910 = Mt910Builder.buildMt910(mt102);
		//build an mt900
		Mt900 mt900 = Mt900Builder.buildMt900(mt102);
		MtCoupler mtc = new MtCoupler(mt900, mt910);
		BankDelegator.sendMt900(mtc);
		BankDelegator.sendMt910(mtc);
	}
	*/

}
