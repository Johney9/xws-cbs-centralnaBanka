package singleton;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;

import javax.security.auth.login.AccountException;
import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import processing.DataProcessing;
import processing.XWSDataProcessor;
import processing.states.CentralBankState;
import processing.states.ProcessingState;
import rs.ac.uns.ftn.xws.cbs.korisnik.Korisnik;
import rs.ac.uns.ftn.xws.cbs.mt102.Mt102;
import rs.ac.uns.ftn.xws.cbs.mt103.Mt103;
import rs.ac.uns.ftn.xws.cbs.mt900.Mt900;
import rs.ac.uns.ftn.xws.cbs.mt910.Mt910;
import util.Mt102ResolverThread;
import util.PropertiesLoader;
import utility.MtCoupler;
import validation.BankAccountValidator;
import builders.central_bank.Mt900Builder;
import builders.central_bank.Mt910Builder;
import delegators.BankDelegator;
import facades.DatabaseFacade;

public class MainCentralBankProcessor {

	protected static final String propertiesName = "ant.properties";
    protected Properties properties = PropertiesLoader.load(propertiesName);
	protected MtCoupler mtc;
	protected DataProcessing processor;
	protected ProcessingState state;
	protected ArrayList<String> swiftCodes;
	protected Mt102ResolverThread mt102resolverThread;
	protected DatabaseFacade dbf;
	
	private MainCentralBankProcessor() {
		state = new CentralBankState();
		processor = new XWSDataProcessor(state);
		swiftCodes = new ArrayList<String>();
		mt102resolverThread = new Mt102ResolverThread();
		try {
			state.initialSetup(properties);
		} catch (Exception e) {
			throw new RuntimeException("Unable to initialise central bank: "+properties.getProperty("war.name")+" in database.");
		}
	}

	private static class SingletonHolder {
        private static final MainCentralBankProcessor INSTANCE = new MainCentralBankProcessor();
	}

	public static MainCentralBankProcessor getInstance() {
	        return SingletonHolder.INSTANCE;
	}

	public void process(Mt102 mt102) throws JAXBException, IOException,
			SAXException, Exception {
		Mt102 processedMt102 = (Mt102) processor.process(mt102);
		String currentSwift = processedMt102.getSwiftKodBankePoverioca();
		addSwiftCode(currentSwift);
		mt102resolverThread.start();
	}
	
	public void resolveMt102s() throws JAXBException, IOException, Exception {
		System.out.println("--starting to resolve mt102s--");
		for(String swift : swiftCodes) {
			Mt102 resolvee = retrieveFromDB(swift);
			System.out.println();
			System.out.printf("--resolving mt102 with swift: %s, id: %s and ukupan iznos: %f --",resolvee.getSwiftKodBankePoverioca(),resolvee.getIdPoruke(), resolvee.getUkupanIznos());
			System.out.println();
			obracun(resolvee);
			delegateToBanks(resolvee);
			System.out.printf("--done resolving mt102 with swift: %s, id: %s and ukupan iznos: %f --",resolvee.getSwiftKodBankePoverioca(),resolvee.getIdPoruke(), resolvee.getUkupanIznos());
			dbf.removeFromDatabase(resolvee, swift);
		}
		removeAllSwiftCodes();
		System.out.println("--all mt102s resolved.--");
		mt102resolverThread.start();
	}

	protected Mt102 retrieveFromDB(String swift) throws JAXBException, SAXException, IOException, Exception {
		dbf = new DatabaseFacade();
		return dbf.readFromDatabase(new Mt102(), swift);
	}
	
	protected void delegateToBanks(Mt102 mt102) throws JAXBException, IOException, Exception {
		ArrayList<Mt910> mt910s = new ArrayList<Mt910>();
		ArrayList<Mt900> mt900s = new ArrayList<Mt900>();
		
		mt910s = Mt910Builder.buildMt910(mt102);
		mt900s = Mt900Builder.buildMt900(mt102);
		
		for(int i=0; i<mt102.getPojedinacniNalozi().size(); i++) {
			BankDelegator.sendMt900(mt900s.get(i));
			BankDelegator.sendMt910(mt910s.get(i));
		}
	}

	public void process(Mt103 mt103) throws JAXBException, IOException,
			SAXException, Exception {
		mtc = (MtCoupler) processor.process(mt103);
		obracun(mt103);
        delegateToBanks(mtc);
		mtc=null;
	}
	
	protected void delegateToBanks(MtCoupler mtc) throws JAXBException, IOException, Exception {
		BankDelegator.sendMt900(mtc.getMt900());
		BankDelegator.sendMt910(mtc.getMt910());
	}

	protected void addSwiftCode(String currentSwift) {
		this.swiftCodes.add(currentSwift);
	}
	
	protected String removeSwiftCode(String swiftCode) {
		return swiftCodes.remove(swiftCodes.indexOf(swiftCode));
	}
	
	protected void removeAllSwiftCodes() {
		swiftCodes.clear();
	}
	
	protected void obracun(Mt102 nalog) throws JAXBException, SAXException, IOException, AccountException, Exception {
		String racunDuznika = nalog.getObracunskiRacunBankeDuznika();
		String racunPoverioca = nalog.getObracunskiRacunBankePoverioca();
		
		BigDecimal iznos = nalog.getUkupanIznos();
		
		Korisnik duznik = BankAccountValidator.validateAccountForTransfer(racunDuznika, iznos);
		BankAccountValidator.validateAccountExternal(racunPoverioca);
		Korisnik poverioc = dbf.readFromDatabase(new Korisnik(), racunPoverioca);
		
		duznik.setStanje(duznik.getStanje().subtract(iznos));
		poverioc.setStanje(poverioc.getStanje().add(iznos));
		
		dbf.storeInDatabase(duznik,racunDuznika);
		dbf.storeInDatabase(poverioc, racunPoverioca);
	}
	
	protected void obracun(Mt103 nalog) throws JAXBException, SAXException, IOException, AccountException, Exception {
		String racunDuznika = nalog.getObracunskiRacunBankeDuznika();
		String racunPoverioca = nalog.getObracunskiRacunBankePoverioca();
		
		BigDecimal iznos = nalog.getIznos();
		
		Korisnik duznik = BankAccountValidator.validateAccountForTransfer(racunDuznika, iznos);
		BankAccountValidator.validateAccountExternal(racunPoverioca);
		Korisnik poverioc = dbf.readFromDatabase(new Korisnik(), racunPoverioca);
		
		duznik.setStanje(duznik.getStanje().subtract(iznos));
		poverioc.setStanje(poverioc.getStanje().add(iznos));
		
		dbf.storeInDatabase(duznik,racunDuznika);
		dbf.storeInDatabase(poverioc, racunPoverioca);
	}
}
