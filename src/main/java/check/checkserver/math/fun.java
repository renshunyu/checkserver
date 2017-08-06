package check.checkserver.math;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
public class fun {
	public double result(double x){
		return Math.pow(x, 0.1);
	}
	
	public double dayresult(){
		double re = 0;
		int i = 0;
		for (i=1;i<=86400;i++){
			re = re + result(i);			
		};
		return re;
	}
	
	public double qzresult(double x){
		return x/dayresult();
	}
	
	public int sresult(double x,double y){
		double a = x/dayresult();
		return  (int) (a*result(y));
	}
	
	public List<?> glist(int a,int b){
		List<Integer> list=new ArrayList<Integer>();
		int i=0;
		for (i=0;i<b;i++){
			list.add(i, (int)(Math.random()*a));
		};
		return list;
	}
	
}
