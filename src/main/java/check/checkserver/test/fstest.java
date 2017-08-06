package check.checkserver.test;

import org.apache.log4j.Logger;


public class fstest {
	static Logger log = Logger.getLogger(fstest.class);
	int i =0;
	char c = 'v';
	String str = "asgr";
	
	
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void f1(){
		log.info("f1");
	}
	
	public void f2(int i){
		log.info("i");
	}


}
