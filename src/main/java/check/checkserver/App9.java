package check.checkserver;

public class App9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,tmp,a[] = {34,67,45,23,43,98,66,32};
		for (i=0;i<a.length-1;i++){
			System.out.println(a[i]);
		}
		
		for (i=0;i<a.length-1;i++){
			for (j=i+1;j<a.length-1;j++){
				if (a[i]<a[j]){
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
				
			}
		}
		for (i=0;i<a.length-1;i++){
			System.out.println(a[i]);
		}
		

	}

}
