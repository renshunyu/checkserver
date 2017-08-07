package check.checkserver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import check.checkserver.compare.ComRunnable;

public class App31 {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, InterruptedException {
		Logger log = Logger.getLogger(App31.class);
		String tp[] = { "TABLE" };
		HashMap<String, String> m = new HashMap<String, String>();
		HashMap<String, String> m1 = new HashMap<String, String>();
		Connection con = null;
		Connection con1 = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.15.42.37:1521:iap", "audit30testc",
				"audit30testc#");
		log.info("连接成功");
		DatabaseMetaData db = con.getMetaData();
		ResultSet rs = db.getTables("", "AUDIT30TESTC", null, tp);
		while (rs.next()) {
			m.put(rs.getString(3), rs.getString(2));
			//log.info(rs.getString(2) + " " + rs.getString(3) + " "
			//		+ rs.getString(4));
		}
		rs.close();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		con1 = DriverManager.getConnection(
				"jdbc:oracle:thin:@10.15.42.37:1521:iap", "audit30testb",
				"audit30testb#");
		log.info("连接成功");
		DatabaseMetaData db1 = con1.getMetaData();
		ResultSet rs1 = db1.getTables("", "AUDIT30TESTB", null, tp);

		while (rs1.next()) {
			m1.put(rs1.getString(3), rs1.getString(2));
			//log.info(rs1.getString(2) + " " + rs1.getString(3) + " "
			//		+ rs1.getString(4));
		}
		rs1.close();

		log.info(m.containsKey("IAP_APP"));
		log.info(m1.containsKey("IAP_APP"));
		
		
		
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		

		
		log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Iterator<?> it = m.entrySet().iterator();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			// log.info(key.toString());
			if (!m1.containsKey(key.toString())) {
				log.info(key.toString() + " " + val.toString());
			} else {
				if (key.toString().indexOf("20")==-1 || key.toString().indexOf(df.format(new Date()))!=-1){
					ComRunnable cr = new ComRunnable();
					cr.setDb(db);
					cr.setDb1(db1);
					StringBuffer s = new StringBuffer();
					s.append(key.toString());
					cr.setKstr(s.toString());
					cachedThreadPool.execute(cr);
				}

			}

		}
		log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

/*		Iterator<?> it1 = m1.entrySet().iterator();
		while (it1.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry1 = (Map.Entry) it1.next();
			Object key1 = entry1.getKey();
			Object val1 = entry1.getValue();
			// log.info(key.toString());
			if (!m.containsKey(key1.toString())) {
				log.info(key1.toString() + " " + val1.toString());
			}

		}*/
/*		while ()
		con.close();
		con1.close();
*/
		// log.info(con.getSchema());

	}

}