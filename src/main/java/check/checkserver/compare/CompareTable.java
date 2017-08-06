package check.checkserver.compare;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;


public class CompareTable {
	static Logger log = Logger.getLogger(CompareTable.class);
	
	public static boolean compare(ResultSet t1,ResultSet t2) throws SQLException{
		
		HashMap<String,String[]> al1 = new HashMap<String,String[]>();
		HashMap<String,String[]> al2 = new HashMap<String,String[]>();
		while (t1.next()){
			String temp1[] = {t1.getString(2),t1.getString(3),t1.getString(7)};	
			al1.put(t1.getString(4), temp1);
		}
		while (t2.next()){
			String temp2[] = {t2.getString(2),t2.getString(3),t2.getString(7)};	
			al2.put(t2.getString(4), temp2);
		}
		
		if(!(al1.size()==al2.size())) return false;
		
		Iterator<?> it1 = al1.entrySet().iterator();
		Iterator<?> it2 = al2.entrySet().iterator();
		while (it1.hasNext() && it2.hasNext()){
			@SuppressWarnings("rawtypes")
			Map.Entry entry1 = (Map.Entry) it1.next();			
			Object key1 = entry1.getKey();
			String val1[] = (String[]) entry1.getValue();
			@SuppressWarnings("rawtypes")
			Map.Entry entry2 = (Map.Entry) it2.next();
			Object key2 = entry2.getKey();
			String val2[] = (String[]) entry2.getValue();
			if (!key1.toString().equals(key2.toString())) return false;
			for (int i=1;i<3;i++){
				if (!val1[i].equals(val2[i])) return false;
			}
			
			
		}

		return true;
		
	}

}
