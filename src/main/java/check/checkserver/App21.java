package check.checkserver;

import org.apache.log4j.Logger;

import check.checkserver.sort.Combine;

public class App21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(App21.class);
		int a[] = {1,2,4,8,9,2,4,5,7,8};
		Combine.combine(a, 1, 4, 8);
		for (int i =0 ;i< a.length;i++) log.info(a[i]);

	}

}
