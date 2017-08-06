package check.checkserver.thread;

import org.apache.log4j.Logger;

public class ImRunable  implements Runnable{
	static Logger log = Logger.getLogger(ImRunable.class);
	private String threadname = "asdfasd";
	private Thread t;
	int a[] = {1,2,3,4};
	
	public String getThreadname() {
		return threadname;
	}

	public void setThreadname(String threadname) {
		this.threadname = threadname;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info(threadname + "线程开始");
		try {
			for(int i: a ){
				log.info("Thread: " + threadname + ", " + i);
				Thread.sleep(1000);	
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Thread " +  threadname + " interrupted.");
		}
		log.info("Thread " +  threadname + " exiting.");
		
		
		
	}
	public void start() throws InterruptedException{
		
		t=new Thread(this);
		if (t !=null) {
			t.start();
			
		}
	}
	

}
