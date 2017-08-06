package check.checkserver.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import check.checkserver.config.config;

public class reflectTest {
	public void re() throws ClassNotFoundException{
		Class<?> c = Class.forName("check.checkserver.config.config");
		System.out.println("属性：");
		Field f[] = c.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
             System.out.println(f[i].getName());
        }
		System.out.println("方法：");
        Method m[] = c.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i].toString());
        }
		
	}
	
	
	public void cbjkl() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		config conf = new config();
		Class<? extends config> c = conf.getClass();
		
		Method m[] = c.getMethods();
		m[0].invoke(conf,null);
		m[1].invoke(conf,null);
		m[2].invoke(conf,"renshunyu");
		
	}
	
	public void objcp() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class c = Class.forName("check.checkserver.config.config");
		Object o = c.getConstructor(new Class[] {}).newInstance(
                new Object[] {});
		
		Method m[] = c.getMethods();
		m[0].invoke(o,null);
		m[1].invoke(o,null);
		m[2].invoke(o,"renshunyu");
	}
	

}
