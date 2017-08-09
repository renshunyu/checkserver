package check.checkserver.math;

public class GsFun {
	public static double p(double avg,double half,double x) {
		//return (1/(half*StrictMath.sqrt(2*StrictMath.PI)))*(StrictMath.exp(-(StrictMath.pow(x-avg, 2))/(2*StrictMath.pow(half,2))));
		return (StrictMath.exp(-(StrictMath.pow(x-avg, 2))/(2*StrictMath.pow(half,2))));
	}

}
