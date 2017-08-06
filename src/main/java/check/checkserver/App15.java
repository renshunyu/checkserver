package check.checkserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.ext.h2.H2Connection;
import org.dbunit.ext.hsqldb.HsqldbConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.ext.oracle.OracleConnection;


public class App15 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(App15.class);
		//--------------oracle-----------------
		Connection con;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:" + "thin:@10.15.42.37:1521:iap";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
        String user = "audit30testc";// 用户名,系统默认的账户名
        String password = "audit30testc#";// 你安装时选设置的密码
        con = DriverManager.getConnection(url, user, password);// 获取连接
        log.info("oracle连接成功");
        ResultSet result = con.prepareStatement("select * from uap_app_acct").executeQuery();
/*        while (result.next())
            // 当结果集不为空时
        	log.info("姓名:"
                    + result.getString("iap_app_code"));*/
        
        //--------------oracle-----------------

        //--------------hive-----------------
        Connection hivecon;
        Class.forName("org.apache.hive.jdbc.HiveDriver");
        hivecon = DriverManager.getConnection(
                "jdbc:hive2://10.1.198.54:10000/aiiaptestc", "clouderauser", "clouderauser");
        log.info("hive连接成功");
        ResultSet hiveresult = hivecon.prepareStatement("select * from uap_app_acct").executeQuery();
        
        assert !hiveresult.equals(result);
        log.info(result.getMetaData().getColumnCount());
        for (int i = 1;i<=result.getMetaData().getColumnCount();i++){
        	log.info(result.getMetaData().getColumnName(i)+":"+result.getMetaData().getColumnTypeName(i));
        }
        while (true){
            // 当结果集不为空时 hiveresult.next() && result.next()
        	boolean re = result.next();
        	boolean hre = hiveresult.next();
        	if (re && hre){
	        	log.info("姓名:"
	                    + result.getString("USER_NAME"));
	        	for (int i = 1;i<=result.getMetaData().getColumnCount();i++){
	        		log.info("第"+i+"列");
	        		switch  (result.getMetaData().getColumnTypeName(i)){
	        		case "NUMBER":
	        			assert hiveresult.getLong(hiveresult.getMetaData().getColumnName(i))==(result.getLong(result.getMetaData().getColumnName(i)));
	        			break;
	        		case "VARCHAR2":
	        			try {
							assert hiveresult.getString(hiveresult.getMetaData().getColumnName(i)).equals(result.getString(result.getMetaData().getColumnName(i)));
						} catch (NullPointerException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							assert hiveresult.getString(hiveresult.getMetaData().getColumnName(i))==null;
							assert result.getString(result.getMetaData().getColumnName(i))==null;
						}
	        			break;
	        		case "TIMESTAMP":
	        			try {
							assert hiveresult.getTimestamp(hiveresult.getMetaData().getColumnName(i)).equals(result.getTimestamp(result.getMetaData().getColumnName(i)));
						} catch (NullPointerException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							assert hiveresult.getString(hiveresult.getMetaData().getColumnName(i))==null;
							assert result.getString(result.getMetaData().getColumnName(i))==null;
						}
	        			break;
	        		case "CHAR":
	        			assert hiveresult.getString(hiveresult.getMetaData().getColumnName(i)).equals(result.getString(result.getMetaData().getColumnName(i)));
	        			break;
	        		default: 
	        			break;
	        		}
	        	}
	        
	        	assert hiveresult.getString("USER_NAME").equals(result.getString("USER_NAME"));
        	}else{
        		assert (re==false) && (hre==false);
        		break;
        	}
        
        }
        //--------------hive-----------------
        
        
        //if (con !=null) con.close();
		
		//Connection c = new Connection();
/*		try {
			IDatabaseConnection connection = new OracleConnection(con,"aiiaptestc");
			IDataSet databaseDataSet = connection.createDataSet();
			ITable actualTable = databaseDataSet.getTable("iap_app");
			log.info(actualTable);
			
		} catch (DatabaseUnitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		

	}

}
