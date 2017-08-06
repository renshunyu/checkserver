package check.checkserver.sort;

public class InsertSort {
	public static int[] sort(int a[]){
		
		int n= a.length;
		
		for (int i =1;i<n;i++){
			int temp = a[i];
			for (int j=0;j<i;j++){
				if (temp <a[i-j-1]) {
					a[i-j] = a[i-j-1];
					
					continue;
					
				} else {
					a[i-j] =temp;
					break;
				}

				
			}
			
		}
		return a ;
		
	}


}
