package check.checkserver.sort;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import check.checkserver.ecp.BhfException;


public class QuickSortTest {
	static Logger log = Logger.getLogger(QuickSortTest.class);
	int a[] = new int[100000];
	@Before
	public void setUp() throws Exception {		
		for (int i = 0; i < a.length; i++) {          
		    int t=(int)(Math.random()*100000);           
		    a[i]=t;      

		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = BhfException.class)
	public void sort3testcep() throws Exception  {
		QuickSort.sort(a, 6, 2);
	}
	@Test
	public void sort3test() throws BhfException  {
		QuickSort.sort(a, 2, 6);
		assert a[2]<=a[3];
		assert a[3]<=a[4];
		assert a[4]<=a[5];
		assert a[5]<=a[6];
	}
	
	@Test
	public void sort1test() throws BhfException  {
		QuickSort.sort(a);
		assert a[2]<=a[3];
		assert a[3]<=a[4];
		assert a[4]<=a[5];
		assert a[5]<=a[6];
	}
	
	
	

}
