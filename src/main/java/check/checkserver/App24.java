package check.checkserver;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class App24 {
	static Logger log = Logger.getLogger(App24.class);
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class<?> a=Class.forName("check.checkserver.test.fstest");
		Object b = a.newInstance();

		Method [] m = a.getMethods();
		
		for (Method mm:m){
			if(mm.getName() =="getC"){
				log.info(mm.invoke(b));
			}
			log.info(mm.getName());
		}
		
		
		
		Field[] f = a.getDeclaredFields();
		log.info(f.length);
		for (Field ff:f){
			if(ff.getName() !="log"){
				ff.setAccessible(true);
				log.info(ff.get(b));
			}
			log.info(ff.getName());
		}
		

	}

}
