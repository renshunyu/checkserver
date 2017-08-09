package check.checkserver.math;

import java.util.Random;

public class GsFb {
	static Random rand = new Random();
	public static int getValue(int a,int b){
		return (int)((rand.nextGaussian()+3)*(b-a)/6+a);
		
	}
	
}
