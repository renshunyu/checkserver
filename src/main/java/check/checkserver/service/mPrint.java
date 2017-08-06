package check.checkserver.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component("mPrint")
public class mPrint {
	private String str = "测试";
	
	public void setStr(String str) {
        this.str = str;
	}
	//@Scheduled(cron = "0 * * * * ?")
	public void mPrint(){
	System.out.println(str);
	}
}
