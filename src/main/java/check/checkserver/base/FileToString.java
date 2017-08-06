package check.checkserver.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import check.checkserver.ecp.MyException; 


public class FileToString {
	public String readFromFile(File src) throws MyException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src),"GBK"));
            StringBuilder stringBuilder = new StringBuilder();
            String content = null;
            while((content = bufferedReader.readLine() )!=null){
                stringBuilder.append(content);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new MyException("没有");
 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }
}
