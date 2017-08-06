package check.checkserver.dz;

import java.util.Stack;

public class bracketMatch {
	public static boolean run(String str) {
		Stack<Character> s = new Stack<Character>();
		for (int i =0;i<str.length();i++){
			switch (str.toCharArray()[i]) {
			case '(':
			case '{':
			case '[': s.push(str.toCharArray()[i]);
			
				break;
			case ')': if(!s.isEmpty()&&(char)s.peek()=='('){
				s.pop();
				break;
			}else{
				return false;
			}
			case '}': if(!s.isEmpty()&&(char)s.peek()=='{'){
				s.pop();
				break;
			}else{
				return false;
			}
			case ']': if(!s.isEmpty()&&(char)s.peek()=='['){
				s.pop();
				break;
			}else{
				return false;
			}

			default:
				break;
			}
		}
		if (!s.isEmpty()){
			return false;
		}else{
			return true;
		}
		
		
	}

}
