package check.checkserver.sort;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;


public class Combine {
	static Logger log = Logger.getLogger(Combine.class);

	public static void combine(int a[], int low, int mid, int high) {
		int i = 0;
		int j = 0;
		LinkedBlockingQueue<Integer> quene = new LinkedBlockingQueue<Integer>(high - mid);

		while (low + i <= mid && mid + 1 + j <= high) {
			if (a[low + i] <= a[mid + 1 + j]) {
				i++;
			} else {
				quene.add(a[low + i]);
				a[low + i] = a[mid + 1 + j];
				j++;
				i++;
				while (quene.size() != 0) {
					int temp = quene.element();

					if (low + i <= mid && mid + 1 + j <= high && temp <= a[mid + 1 + j]) {
						quene.remove();
						quene.add(a[low + i]);
						a[low + i] = temp;
						
						i++;
					} else if (low + i <= mid && mid + 1 + j <= high) {
						quene.add(a[low + i]);
						a[low + i] = a[mid + 1 + j];
						j++;
						i++;
					} else if (low + i <= mid && mid + 1 + j > high) {
						quene.remove();
						quene.add(a[low + i]);
						a[low + i] = temp;
						
						i++;
					} else if (low + i > mid && mid + 1 + j <= high && temp > a[mid + 1 + j]) {
						a[low + i] = a[mid + 1 + j];
						j++;
						i++;
					}else {
						a[low + i] = temp;
						quene.remove();
						i++;
					}
				}
			}
		}
	}
	public static void sort(int a[],int low,int high) {
		if (low !=high){
			int mid = (int)((low+high)/2);
			sort(a,low,mid);
			sort(a, mid+1, high);
			combine(a,low,mid,high);
		}
		
	}
	
	public static void sort(int a[]) {
		sort(a,1,a.length-1);
		
	}
	

}
