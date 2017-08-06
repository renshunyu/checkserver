package check.checkserver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello world!";
		Pattern p = Pattern.compile("[a-zA-Z]");
		int i;
		for (i=0;i<str.length();i++){
			Matcher m = p.matcher(String.valueOf(str.toCharArray()[i]));
			if (m.find()){
				
				System.out.println(m.group());
			}
			
		}
		

		
		

	}

}
