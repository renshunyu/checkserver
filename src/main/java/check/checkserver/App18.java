package check.checkserver;

import org.apache.log4j.Logger;

import check.checkserver.fanxing.Fx;

public class App18 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(App18.class);
		String s = "adadf";
		Fx<String> fx = new Fx<String>();
		fx.setT(s);
		log.info(fx.getT());
		
		

	}

}
