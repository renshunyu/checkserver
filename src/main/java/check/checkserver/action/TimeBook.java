package check.checkserver.action;

import org.apache.log4j.*;
import check.checkserver.Interface.*;
public class TimeBook implements TimeBookInterface{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void rensy(String name){
		logger.log(Level.INFO,name+"start");
		System.out.println(name);
		logger.log(Level.INFO,name+"stop");
	}

}
