package check.checkserver.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class config {
	
	private String a;
	
	Properties p = new Properties();
	public void conf() throws IOException{
		InputStream is = new FileInputStream(new File(".\\src\\main\\resources\\config.propertity"));
		p.load(is);
		System.out.println(p.getProperty("aa"));
	}
	
	public void seta(String a){
		this.a = a;
		System.out.println(a);
	}
	
	public void printa(){
		System.out.println(this.a);
	}
	
	
	

}
