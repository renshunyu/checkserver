package check.checkserver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

import check.checkserver.compare.CompareTable;

public class App17 {
	public enum EnumTest {
	    MON, TUE, WED, THU, FRI, SAT, SUN;
	}
	public static void main(String[] args) {
		Logger log = Logger.getLogger(App17.class);
		Enumeration<String> days;
		Vector<String> al = new Vector<String>();
		al.add("asd");
		al.add("asd");
		al.add("sdf");
		al.add("fhj");
		days = al.elements();
		while (days.hasMoreElements()){
			log.info(days.nextElement());
			
		}
		
		Iterator<String> i = al.iterator();
		while (i.hasNext()){
			log.info(i.next());
		}
		
	}
		
		// log.info(con.getSchema());
	
}

