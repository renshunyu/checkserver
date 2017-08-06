package check.checkserver.base;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDeal {
	public String strdeal(String str){
		Date date = new Date();
	    SimpleDateFormat formater = new SimpleDateFormat();
	    formater.applyPattern("yyyy-MM-dd HH:mm:ss");
		String shijian = formater.format(date);
	    System.out.println(shijian);
		str = str.replaceAll("<OPERATE_TIME>.*?</OPERATE_TIME>", "<OPERATE_TIME>" + shijian + "</OPERATE_TIME>");
		str = str.replaceAll("<IDR_CREATION_TIME>.*?</IDR_CREATION_TIME>", "<IDR_CREATION_TIME>" + shijian + "</IDR_CREATION_TIME>");
		str = str.replaceAll("<SESSION_BEGIN_TIME>.*?</SESSION_BEGIN_TIME>", "<SESSION_BEGIN_TIME>"+shijian+"</SESSION_BEGIN_TIME>");
		str = str.replaceAll("<SESSION_END_TIME>.*?</SESSION_END_TIME>", "<SESSION_END_TIME>"+shijian+"</SESSION_END_TIME>");
		return str;		
	}	
	public String strdeal2(String str){
		str = str.replaceAll("<ROOT>","");
		str = str.replaceAll("</ROOT>","");
		return str;
	}	
	public String strdeal3(String str){
		str = "<ROOT>" + str + "</ROOT>";
		return str;
	}
}
