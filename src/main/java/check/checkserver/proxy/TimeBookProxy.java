package check.checkserver.proxy;

import org.apache.log4j.*;

import check.checkserver.Interface.*;
public class TimeBookProxy {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private TimeBookInterface timeBookInterface;
	
	public TimeBookProxy(TimeBookInterface timeBookInterface){
		this.timeBookInterface = timeBookInterface;
	}
	
	public void rensy(String name){
		logger.log(Level.INFO,name+"start");
		timeBookInterface.rensy(name);
		logger.log(Level.INFO,name+"stop");
	}

}
