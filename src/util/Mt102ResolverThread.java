package util;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import singleton.MainCentralBankProcessor;

public class Mt102ResolverThread extends Thread {

	private int timerLength=10*100; //ms

	public Mt102ResolverThread() {}
	
	public Mt102ResolverThread(int TIMER_LENGHT) {
		this.timerLength=TIMER_LENGHT;
	}
	
	@Override
	public void run() {
		System.out.println("--starting mt102 resolver thread--");
		try {
			Thread.sleep(timerLength);
			MainCentralBankProcessor.getInstance().resolveMt102s();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTimerLength() {
		return timerLength;
	}

}
