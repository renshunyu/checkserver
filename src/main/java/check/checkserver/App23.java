package check.checkserver;

import org.apache.log4j.Logger;

public class App23 {
	static int i =0;
	static Logger log = Logger.getLogger(App22.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.info(hnt(13,'a','b','c'));
		log.info("asdfa" instanceof String);
		
		

	}
	public static int hnt(int n,char x, char y,char z) {
		// TODO Auto-generated method stub
		if(1==n){
			//z=x;
			move(x,z);
			i++;
			log.info(i);
		}else if(1<n){
			hnt(n-1,x,z,y);
			move(x,z);
			i++;
			log.info(i);
			hnt(n-1,y,x,z);
			log.info(i);
					
		}
		return i;

	}
	
	public static void move(char f,char t) {
		// TODO Auto-generated method stub
			log.info("从"+f+"移动到"+t);
	}
	
	

}
