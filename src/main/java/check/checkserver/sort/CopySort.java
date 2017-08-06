package check.checkserver.sort;

import java.util.ArrayList;
import java.util.HashMap;

public class CopySort {
	public static void sort(int a[]) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int k=0;
		for (int i=0;i<a.length;i++){
			if (!map.containsKey(a[i])){
				ArrayList<Integer> array = new ArrayList<Integer>();
				array.add(i);
				map.put(a[i], array);
			}else{
				map.get(a[i]).add(i);
			}
		}
		
		for (int i=0;i<a.length;i++){
			if (map.containsKey(i)){
				for (int j=0 ;j<map.get(i).size();j++){
					a[k] = i;
					k++;
				}
			}
		}
	}

}
