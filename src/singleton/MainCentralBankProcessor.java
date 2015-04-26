package singleton;

import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import processing.DataProcessing;
import processing.XWSDataProcessor;
import processing.states.CentralBankState;
import processing.states.ProcessingState;
import rs.ac.uns.ftn.xws.cbs.mt102.Mt102;
import rs.ac.uns.ftn.xws.cbs.mt103.Mt103;
import util.PropertiesLoader;
import utility.MtCoupler;
import delegators.BankDelegator;

public class MainCentralBankProcessor {

	protected static final String propertiesName = "ant.properties";
    protected Properties properties = PropertiesLoader.load(propertiesName);
	protected MtCoupler mtc;
	protected DataProcessing processor;
	protected ProcessingState state;
	
	private MainCentralBankProcessor() {
		state = new CentralBankState();
		processor = new XWSDataProcessor(state);
	}

	private static class SingletonHolder {
        private static final MainCentralBankProcessor INSTANCE = new MainCentralBankProcessor();
	}

	public static MainCentralBankProcessor getInstance() {
	        return SingletonHolder.INSTANCE;
	}

	public void process(Mt102 mt102) throws JAXBException, IOException,
			SAXException, Exception {
		mtc = (MtCoupler) processor.process(mt102);
        
		BankDelegator.sendMt900(mtc);
		BankDelegator.sendMt910(mtc);
	
		mtc=null;
	}

	public void process(Mt103 mt103) throws JAXBException, IOException,
			SAXException, Exception {
		mtc = (MtCoupler) processor.process(mt103);
        
		BankDelegator.sendMt900(mtc);
		BankDelegator.sendMt910(mtc);
		
		mtc=null;
	}
	
	

}
