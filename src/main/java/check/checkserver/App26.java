package check.checkserver;

import org.apache.log4j.Logger;

import check.checkserver.thread.ImRunable;

public class App26 {
	static Logger log = Logger.getLogger(App26.class);
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		ImRunable ir = new ImRunable();
		ir.start();
		Thread.sleep(2000);
		ir.start();
		
		
		

	}

}
