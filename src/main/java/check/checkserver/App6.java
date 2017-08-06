package check.checkserver;


import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import check.checkserver.math.fun;
import check.checkserver.service.MyTcpSend;


public class App6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		fun f = new fun();
		System.out.println(f.result(1));
		System.out.println(f.dayresult());
		System.out.println(f.qzresult(10000000));
		System.out.println(f.sresult(10000000, 10000));
		Calendar calendar = Calendar.getInstance();
		
		int hours = calendar.get(Calendar.HOUR_OF_DAY); // 时
		int minutes = calendar.get(Calendar.MINUTE);    // 分
		int seconds = calendar.get(Calendar.SECOND);    // 秒
		int dayseconds = hours*60*60 + minutes*60 + seconds;
		System.out.println(String.format("hours: %s,minutes: %s,seconds: %s,dayseconds: %s", hours, minutes, seconds,dayseconds));
		
		
		
		
		System.out.println(f.glist(129, 10).toArray()[1]);
		List<?> list = f.glist(129, 10);
		MyTcpSend tsend = new MyTcpSend();
		System.out.println(tsend.getnum());
		System.out.println("哈哈哈哈哈哈哈哈");
		tsend.isend2(list);
		System.out.println("哈哈哈哈哈哈哈哈");
		
		
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		while (true) {
			
			
			cachedThreadPool.execute(new Runnable() {  
			    public void run() {  
			    	Calendar calend = Calendar.getInstance();
			    	fun f = new fun();
			    	System.out.println(f.sresult(10000000,calend.get(Calendar.HOUR)*3600 + calend.get(Calendar.MINUTE)*60 + calend.get(Calendar.SECOND))); 
			    	
			    }  
			});
			Thread.sleep(1000);
		}
		
	}
	
	
}
