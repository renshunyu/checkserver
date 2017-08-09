package check.checkserver;

import org.apache.log4j.Logger;

import check.checkserver.math.GsFb;


public class App32 {
	static Logger log = Logger.getLogger(App32.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GsFb.getValue(1, 10);
		for (int i=0;i<100;i++){
			log.info(GsFb.getValue(10, 20));
		}

	}

}
