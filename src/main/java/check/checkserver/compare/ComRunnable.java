package check.checkserver.compare;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class ComRunnable implements Runnable{
	Logger log = Logger.getLogger(ComRunnable.class);
	public DatabaseMetaData db;
	public DatabaseMetaData db1;
	public String kstr;
	public String getKstr() {
		return kstr;
	}

	public void setKstr(String kstr) {
		this.kstr = kstr;
	}

	public DatabaseMetaData getDb() {
		return db;
	}

	public void setDb(DatabaseMetaData db) {
		this.db = db;
	}

	public DatabaseMetaData getDb1() {
		return db1;
	}

	public void setDb1(DatabaseMetaData db1) {
		this.db1 = db1;
	}

	public void run() {
		// TODO Auto-generated method stub
		log.info(kstr + "线程开始！");
		
		try {
			ResultSet t = db.getColumns("", "AUDIT30TESTC", kstr,
					null);
			ResultSet t1 = db1.getColumns("", "AUDIT30TESTB",
					kstr, null);
			if (!CompareTable.compare(t, t1))
				log.info(kstr + "字段类型或字段类型不一致！");
			t.close();
			t1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
