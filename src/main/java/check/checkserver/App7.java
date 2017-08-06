package check.checkserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import check.checkserver.base.FileToString;
import check.checkserver.base.StringDeal;
import check.checkserver.sendlog.SendLogOper;

public class App7 {

	public static void main(String[] args) throws Exception {
		
		if (args.length != 3)
        {
          System.out.println("参数不够，参数为：配置文件名称，报文目录，发送间隔[单位为秒]");
          System.out.println(args.length);
          System.out.println(args[0]);
          System.out.println(args[1]);
          System.out.println(args[2]);
          return;
        }
        String conf = args[0];
        String recordPath = args[1];
        String sleepTIme = args[2];
        System.out.println(conf);
        System.out.println(recordPath);
        System.out.println(sleepTIme);
        
        String properFile = ".\\src\\main\\resources\\" + conf + ".properties";
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


        System.out.println(p.getProperty("gather-ip-0"));

        
        SendLogOper sed = new SendLogOper();

        
        while (true){
     	   File file = new File(recordPath);
     	   if (!(file.isDirectory())) {
     		   System.out.println("报文目录有误");
     		   System.out.println("path=" + file.getPath());
     		   System.out.println("absolutepath=" + file.getAbsolutePath());
     		   System.out.println("name=" + file.getName());
     	   }
     	   else if (file.isDirectory()) {
     		   System.out.println("读取目录文件");
     		   String[] filelist = file.list();
     		   for (int i = 0; i < filelist.length; ++i) {
     			   File readfile;
     			   try {
     				   readfile = new File(recordPath + "\\" + new String(new String(filelist[i])));
     			   }
     			   catch (Exception e){
     				   e.printStackTrace();
     				   return;
     			   }
     			   if (!(readfile.isDirectory())) {
     				   System.out.println("path=" + readfile.getPath());
     				  FileToString ee = new FileToString();
     				 StringDeal sd = new StringDeal();
     				   sed.tcpSend(sd.strdeal(ee.readFromFile(new File(readfile.getPath()))));
     				 
     			   }
     			   else if (readfile.isDirectory()) {
     				   System.out.println(readfile.getAbsolutePath() + "为目录");
     			   }
     		   }
     	   }
     	   System.out.println("发送结束");
     	   long sleeptime = Integer.parseInt(sleepTIme) * 1000;
     	   try{
     		   Thread.sleep(sleeptime);
     	   }
     	   catch (Exception e){
     		   e.printStackTrace();
     	   }
        }

	}

}
