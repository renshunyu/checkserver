package check.checkserver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import check.checkserver.Interface.InputFuntionInterface;

public class App28 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		InputFuntionInterface f;
		Class c = Class.forName("check.checkserver.base.GsInput");
		f= (InputFuntionInterface) c.newInstance();
		System.out.println(f.result(900));
		Method m = c.getDeclaredMethod("result",double.class);
		System.out.println(m.invoke(f, 1200));

	}

}
