package check.checkserver.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogProxy implements InvocationHandler{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object delegate;
	
	public Object bind(Object delegate){
		this.delegate = delegate;
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
		
	}
	
	public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
		Object result = null;
		try{
			logger.log(Level.INFO,args[0]+"start");
			result = method.invoke(delegate, args);
			logger.log(Level.INFO,args[0]+"start");
		}catch (Exception e){
			logger.log(Level.INFO,e.toString());
			
		}
		return result;
	}

}
