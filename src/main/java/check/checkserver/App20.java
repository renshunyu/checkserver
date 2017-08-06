package check.checkserver;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import org.apache.log4j.Logger;

import check.checkserver.dz.bracketMatch;

public class App20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(App20.class);
		Stack s= new Stack();
		s.push("sdfas");
		s.push("asgf");
		s.push("sdfju");
		
		log.info(s.peek());
		log.info(s.size());
		//Queue q = new ArrayDeque();
		
		log.info(bracketMatch.run("a[f{d}a(grg)]"));



	}

}
