package check.checkserver.sort;

public class SelectSort {

	public static int[] sort(int a[]){
		
		int n= a.length;
		
		for (int i =0;i<n-1;i++){
			int min = i;
			for (int j=i+1;j<n;j++){
				if (a[j]<a[min]){
					min =j;
				}
			}
			if (i!=min){
				int temp;
				temp = a[i];
				a[i]=a[min];
				a[min]=temp;
				
			}
			
		}
		return a;
		
	}

}
