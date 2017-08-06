package check.checkserver.sort;

import org.apache.log4j.Logger;

import check.checkserver.ecp.BhfException;


public class QuickSort {
	static Logger log = Logger.getLogger(QuickSort.class);
	private static int partition(int a[],int low,int high) {
		int mid = a[low];
		
		while (low <high){
			while(low <high && a[high] >=mid) high--;
			a[low]=a[high];
			while (low <high && a[low] <=mid) low++;
			a[high]=a[low];
		}
		a[low]=mid;
		return low;
		
	}
	
	
	public static void sort(int a[],int low,int high) throws BhfException {
		if(low-1>high){throw new BhfException("low大于了high");}
		if ( low <high){
			int midindex = partition(a,low,high);
			sort(a,low,midindex-1);
			sort(a,midindex+1,high);
		}
		
	}
	
	public static void sort(int a[]) throws BhfException {
		sort(a,0,a.length-1);
	}


}
