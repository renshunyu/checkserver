package check.checkserver.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import check.checkserver.Interface.SendInterface;
import check.checkserver.base.FileToString;
import check.checkserver.base.StringDeal;
import check.checkserver.ecp.MyException;
import check.checkserver.sendlog.SendLogOper;

public class MyTcpSend  implements SendInterface {
	File fi;
	public int getnum() {
		// TODO Auto-generated method stub
		fi = new File(".\\src\\main\\record");
		if (fi.isDirectory()){
			return fi.list().length;
		}else{
			return 0;
		}
	}


	public void isend(List<?> list) {
		// TODO Auto-generated method stub
		SendLogOper slo = new SendLogOper();
		String properFile = ".\\src\\main\\resources\\uac.properties";
        File pFile = new File(properFile);
        FileInputStream pInStream = null;
        try
        {
          pInStream = new FileInputStream(pFile);
        }
        catch (FileNotFoundException e)
        {
          e.printStackTrace();
        }
        Properties p = new Properties();
        try
        {
          p.load(pInStream);
          pInStream.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
		HashMap ha = new HashMap();
        System.out.println(p.getProperty("gather-ip-0"));
        ha.put("gather-ip-0", p.getProperty("gather-ip-0"));
        ha.put("gather-port-0", p.getProperty("gather-port-0"));
        ha.put("backup-directory", p.getProperty("backup-directory"));
        ha.put("pool-max-capacity", p.getProperty("pool-max-capacity"));
        ha.put("pool-max-send-workers", p.getProperty("pool-max-send-workers"));
        slo.initSendPool(ha);
        FileToString ee = new FileToString();
		int i = 0;
		for (i=0;i<list.toArray().length;i++){
			System.out.println(list.get(i));
			try {
				slo.tcpSend(ee.readFromFile(new File(fi.getPath()+"\\"+fi.list()[(Integer) list.get(i)])));
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void isend2(List<?> list) {
		// TODO Auto-generated method stub
		SendLogOper slo = new SendLogOper();
		String properFile = ".\\src\\main\\resources\\uac.properties";
        File pFile = new File(properFile);
        FileInputStream pInStream = null;
        try
        {
          pInStream = new FileInputStream(pFile);
        }
        catch (FileNotFoundException e)
        {
          e.printStackTrace();
        }
        Properties p = new Properties();
        try
        {
          p.load(pInStream);
          pInStream.close();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
		HashMap ha = new HashMap();
        System.out.println(p.getProperty("gather-ip-0"));
        ha.put("gather-ip-0", p.getProperty("gather-ip-0"));
        ha.put("gather-port-0", p.getProperty("gather-port-0"));
        ha.put("backup-directory", p.getProperty("backup-directory"));
        ha.put("pool-max-capacity", p.getProperty("pool-max-capacity"));
        ha.put("pool-max-send-workers", p.getProperty("pool-max-send-workers"));
        slo.initSendPool(ha);
        FileToString ee = new FileToString();
        StringDeal sd = new StringDeal();
		int i = 0;
		String str1 = null;
		for (i=0;i<list.toArray().length;i++){
			System.out.println(list.get(i));
			try {
				str1 = str1 + sd.strdeal2(ee.readFromFile(new File(fi.getPath()+"\\"+fi.list()[(Integer) list.get(i)])));
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		str1 = sd.strdeal3(str1);
		slo.tcpSend(str1);
	}

}
