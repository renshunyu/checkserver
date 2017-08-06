package check.checkserver.action;
import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogAround implements MethodInterceptor{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	//负责输出日志信息的代码
	public Object invoke(MethodInvocation mi) throws Throwable{
		logger.log(Level.INFO,mi.getArguments()[0]+"start");
		try{
		Object result = mi.proceed();
		
		return result;
		}
		finally{
			logger.log(Level.INFO,mi.getArguments()[0]+"stop");
		}
	}
}

