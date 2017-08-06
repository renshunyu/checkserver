package check.checkserver.service;

import java.io.File;
import java.util.List;

import check.checkserver.Interface.SendInterface;
import check.checkserver.sendlog.SendLogOper;
;

public class TcpSend implements SendInterface {

	public int getnum() {
		// TODO Auto-generated method stub
		File fi = new File(".\\src\\main\\record");
		if (fi.isDirectory()){
			return fi.list().length;
		}else{
			return 0;
		}
	}

	public void isend(List<?> list) {
		// TODO Auto-generated method stub
		int i = 0;
		for (i=0;i<list.toArray().length;i++){
			System.out.println(list.get(i));
		};
		
	}

}
