package check.checkserver;

import java.util.HashMap;


public class App10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "qwertrewq";
		HashMap<Character,Integer> ha = new  HashMap<Character,Integer> ();;
		int i;
		for (i=0;i<str.length();i++){
			if (ha.containsKey(str.toCharArray()[i])) {
				System.out.println(str.toCharArray()[i]);
				break;
			}else{
				ha.put(str.toCharArray()[i], 1);
			}
		}
		System.out.println();
		StringBuffer b = new StringBuffer();
		b.append(str);
		b.reverse();
		if (b.toString().equals(str)) System.out.println(true);
		

		

	}

}
