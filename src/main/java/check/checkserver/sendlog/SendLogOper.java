package check.checkserver.sendlog;

import java.util.HashMap;

import com.asiainfo.simulator.tcp.pool.SendPool;

public class SendLogOper {
	private static boolean hasStartup = false;
	public void initSendPool(HashMap<String, String> hm){
    	if (hasStartup)
    		return;
    	try{
    		SendPool.getInstance().init(hm);
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	SendPool.getInstance().startup();
    	hasStartup = true;
    }
    
    public void tcpSend(String sendLog){
    	try{
	        System.out.println("snedlog=" + sendLog);
	        SendPool.getInstance().putMessage(sendLog.getBytes("UTF-8"));
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }

}
