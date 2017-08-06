package check.checkserver;

import org.apache.log4j.Logger;

public class App22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(App22.class);
		String str = "rgwegfsdf";
		
		StringBuffer sb = new StringBuffer(str);
		log.info(sb);
		sb.reverse();
		log.info(sb);
		
		
		String string="runoob";
	    String reverse = new StringBuffer(string).reverse().toString();
	    System.out.println("字符串反转前:"+string);
	    System.out.println("字符串反转后:"+reverse);
		

	}

}
