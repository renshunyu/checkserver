package check.checkserver;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.asiainfo.simulator.tcp.pool.SendPool;

import check.checkserver.base.FileToString;

public class App27 {
	static Logger log =Logger.getLogger(App27.class);
	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		HashMap ha = new HashMap();
		ha.put("gather-ip-0", "10.1.198.61");
        ha.put("gather-port-0", "54444");
        ha.put("backup-directory", ".");
        ha.put("pool-max-capacity", "10");
        ha.put("pool-max-send-workers", "1");
        FileToString fts = new FileToString();
        SendPool.getInstance().init(ha);
        SendPool sp = SendPool.getInstance();
        
        //while (true)
        //{
        	log.info("aaaaaa");
        	sp.getInstance().startup();
        	log.info("bbbbbb");
        	//sp.getInstance().putMessage("sgd".getBytes());
        	sp.getInstance().putMessage(fts.readFromFile(new File("record\\编辑授权实体.txt")).getBytes("UTF-8"));
        	Thread.sleep(1000);
        	
        	log.info("cccccc");
        //}

        


	}

}
