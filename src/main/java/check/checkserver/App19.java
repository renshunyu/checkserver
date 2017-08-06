package check.checkserver;

import org.apache.log4j.Logger;

import check.checkserver.ecp.BhfException;
import check.checkserver.sort.Combine;
import check.checkserver.sort.CopySort;
import check.checkserver.sort.InsertSort;
import check.checkserver.sort.QuickSort;
import check.checkserver.sort.SelectSort;

public class App19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(App19.class);
		int a[] = new int[100000];
		for (int i = 0; i < a.length; i++) {          

		    int t=(int)(Math.random()*100000);           
		    a[i]=t;      

		}
		
		for (int i =0 ;i< a.length;i++) log.info(a[i]);
		long start = System.currentTimeMillis();
		try {
			InsertSort.sort(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("----------------------------------");
		for (int i =0 ;i< a.length;i++) log.info(a[i]);
		log.info(end-start);


	}

}
