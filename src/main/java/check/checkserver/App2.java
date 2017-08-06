package check.checkserver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import check.checkserver.Interface.TimeBookInterface;
import check.checkserver.action.*;
import check.checkserver.proxy.*;
public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeBook t3 = new TimeBook();
		t3.rensy("fwerf");
		
		TimeBookProxy t4 = new TimeBookProxy(new TimeBook());
		t4.rensy("fwerfhaha");
		
		LogProxy mylog  = new LogProxy();
		TimeBookInterface t5 = (TimeBookInterface)mylog.bind(new TimeBook());
		t5.rensy("zhangsan");
		
		ClassPathXmlApplicationContext actx=new ClassPathXmlApplicationContext("config.xml");
		TimeBookInterface timeBookProxy=(TimeBookInterface)actx.getBean("logProxy");
		timeBookProxy.rensy("asfdasdfasdf");
		actx.close();

	}

}
