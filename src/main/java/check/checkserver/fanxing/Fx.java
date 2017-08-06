package check.checkserver.fanxing;

import org.apache.log4j.Logger;

public class Fx<T> {
	Logger log = Logger.getLogger(Fx.class);
	private T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	

}
